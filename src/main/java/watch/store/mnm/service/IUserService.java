package watch.store.mnm.service;

import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.domain.User;
import watch.store.mnm.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> findAll();

    UserDTO findById(int id);

    User create(User user);
}
