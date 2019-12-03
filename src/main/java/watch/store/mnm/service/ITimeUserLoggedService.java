package watch.store.mnm.service;

import watch.store.mnm.domain.TimeUserLogged;
import watch.store.mnm.domain.User;

import java.util.List;

public interface ITimeUserLoggedService {
    List<TimeUserLogged> getAllTimeUserLoggedByUser(User user);
}
