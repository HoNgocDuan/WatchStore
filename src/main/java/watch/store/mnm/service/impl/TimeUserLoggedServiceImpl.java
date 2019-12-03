package watch.store.mnm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import watch.store.mnm.domain.TimeUserLogged;
import watch.store.mnm.domain.User;
import watch.store.mnm.repository.TimeUserLoggedRepository;
import watch.store.mnm.service.ITimeUserLoggedService;

import java.util.List;

@Service
public class TimeUserLoggedServiceImpl implements ITimeUserLoggedService {

    @Autowired
    private TimeUserLoggedRepository timeUserLoggedRepository;

    @Override
    public List<TimeUserLogged> getAllTimeUserLoggedByUser(User user) {
        return timeUserLoggedRepository.getTimeUserLoggedByUserOrderByIdDesc(user, PageRequest.of(0,6));
    }
}
