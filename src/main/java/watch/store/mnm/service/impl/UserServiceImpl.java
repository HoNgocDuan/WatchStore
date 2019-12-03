package watch.store.mnm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.store.mnm.domain.User;
import watch.store.mnm.dto.UserDTO;
import watch.store.mnm.repository.UserRepository;
import watch.store.mnm.service.IUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> listUser = new ArrayList<>();
        List<User> all = userRepository.findAll();
        for (User user: all) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getUsername());
            userDTO.setFirstname(user.getFirstname());
            userDTO.setLastname(user.getLastname());
            userDTO.setAddress(user.getAddress());
            userDTO.setPhoneNumber(user.getPhoneNumber());
            userDTO.setFacebookUrl(user.getFaceBookUrl());
            userDTO.setDescription(user.getDescription());
            userDTO.setEmail(user.getEmail());
            listUser.add(userDTO);
        }
        return listUser;
    }

    @Override
    public UserDTO findById(int id) {
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findById(id);
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setAddress(user.getAddress());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setFacebookUrl(user.getFaceBookUrl());
        userDTO.setDescription(user.getDescription());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    @Override
    public User create(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }
}

