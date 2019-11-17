package watch.store.mnm.service;

import watch.store.mnm.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);


}
