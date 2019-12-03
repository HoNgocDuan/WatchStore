package watch.store.mnm.service;

import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import watch.store.mnm.component.AccountSeeding;
import watch.store.mnm.domain.*;
import watch.store.mnm.dto.ManufactureDTO;
import watch.store.mnm.dto.UserDTO;
import watch.store.mnm.repository.RoleRepository;
import watch.store.mnm.repository.TimeUserLoggedRepository;
import watch.store.mnm.repository.UserRepository;
import watch.store.mnm.service.impl.RoleServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class UserService implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeUserLoggedRepository timeUserLoggedRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String username  =  event.getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        if(user!=null)  {
            TimeUserLogged timeUserLogged = new TimeUserLogged();
            timeUserLogged.setTimeLogged(new Date());
            timeUserLogged.setUser(user);
            timeUserLoggedRepository.save(timeUserLogged);
        }

    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public long countAllUser() {
        return userRepository.count();
    }
    public User save(User user) {
        return userRepository.save(user);
    }




    public User setValueUserDtoToUser(UserDTO userDTO,User user) {
        user.setFaceBookUrl(userDTO.getFacebookUrl());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setAddress(userDTO.getAddress());
        user.setDescription(userDTO.getDescription());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setInterests(userDTO.getInterests());
        user.setOccupation(userDTO.getOccupation());
        return user;
    }

    public User mapUserDtoToUser(UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        boolean checkRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(
                o -> o.getAuthority().equals(AccountSeeding.ROLE_ADMIN));

        if (checkRole) {
            user.setCreateBy(SecurityContextHolder.getContext().getAuthentication().getName());
        } else {
            user=null;
        }
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setFaceBookUrl(userDTO.getFacebookUrl());
        user.setAddress(userDTO.getAddress());
        user.setDescription(userDTO.getDescription());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setInterests(userDTO.getInterests());
        user.setOccupation(userDTO.getOccupation());
        user.setPassword(passwordEncoder.encode(AccountSeeding.PASSWORD_DEFAULT));
        user.setBirthDate(new java.sql.Date(0));
        user.setGender(userDTO.getGender()==0 ? Gender.MALE : userDTO.getGender()==1 ? Gender.FEMALE : Gender.OTHER);
        user.setActive(userDTO.isActive());
        user.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
        try {
            File file = new ClassPathResource(AccountSeeding.PATH_DEFAULT_IMAGE).getFile();
            byte[]  imgByte = new byte[(int)file.length()];
            FileInputStream fileInputStream  = new FileInputStream(file);
            fileInputStream.read(imgByte);
            user.setImage(imgByte);
        } catch (IOException ex) {

        }
        Role role = new Role(AccountSeeding.ROLE_EMPLOYEE);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }
}
