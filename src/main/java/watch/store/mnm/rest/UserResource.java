package watch.store.mnm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import watch.store.mnm.domain.TimeUserLogged;
import watch.store.mnm.domain.User;
import watch.store.mnm.dto.TimeUserLoggedDTO;
import watch.store.mnm.dto.UserDTO;
import watch.store.mnm.exception.DuplicateUserException;
import watch.store.mnm.exception.MessageException;
import watch.store.mnm.service.IUserService;
import watch.store.mnm.service.UserService;
import watch.store.mnm.service.impl.RoleServiceImpl;
import watch.store.mnm.service.impl.TimeUserLoggedServiceImpl;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class UserResource {

//    @Autowired
//    private UserService userService;
//
//    @GetMapping(value = "/all")
//    public @ResponseBody List<User> getAll() {
//        return userService.findAll();
//    }
//
//    @GetMapping(value = "/user/{id}")
//    public @ResponseBody User findById(@PathVariable("id") int id) {
//        return userService.findById(id);
//    }

    @Autowired
    private  IUserService iUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private TimeUserLoggedServiceImpl timeUserLoggedService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDTO userDTO;
        if (username == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "please login");
        } else {
            Set<String> listRoleCurrentUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(o -> o.getAuthority()).collect(Collectors.toSet());
            User user = userService.findByUserName(username);
            if (user == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MessageException.USER_NOT_EXISTS);
            }
            long countAllUser = userService.countAllUser();
            List<TimeUserLogged> allTimeOfCurrentUserLogged = timeUserLoggedService.getAllTimeUserLoggedByUser(user);
            List<TimeUserLoggedDTO> timeUserLoggedDTOList = new ArrayList<>();

            SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
            for (TimeUserLogged time : allTimeOfCurrentUserLogged) {
                timeUserLoggedDTOList.add(new TimeUserLoggedDTO(timeFormat.format(time.getTimeLogged())));
            }
            userDTO = new UserDTO(user, countAllUser, timeUserLoggedDTOList);
            userDTO.setRoleNameVietNamese(listRoleCurrentUser);
        }
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("user/create") public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO)  {
        User userByUsername = userService.findByUserName(userDTO.getUsername());
        if(userByUsername!=null) {
            throw new DuplicateUserException(MessageException.USER_ALDEADY_EXISTS);
        }
        User user = userService.mapUserDtoToUser(userDTO);
        if (user==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,MessageException.NOT_ADMIN);
        }
        return ResponseEntity.ok().body(new UserDTO(userService.save(user)));
    }





    @GetMapping(value = "/user")
    public ResponseEntity<List<UserDTO>> findAll() {

        return ResponseEntity.ok().body(iUserService.findAll());
    }

    @GetMapping(value = "/user/{id}")
    public @ResponseBody UserDTO findById(@PathVariable("id") int id) {
        return iUserService.findById(id);
    }

//    @PostMapping(value = "/user")
//    public @ResponseBody User createUser(@RequestBody UserDTO userDTO) {
//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//        return iUserService.create(user);
//    }
}
