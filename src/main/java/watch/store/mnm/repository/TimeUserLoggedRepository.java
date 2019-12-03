package watch.store.mnm.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import watch.store.mnm.domain.TimeUserLogged;
import watch.store.mnm.domain.User;

import java.util.List;

public interface TimeUserLoggedRepository extends JpaRepository<TimeUserLogged, Integer> {
    List<TimeUserLogged> getTimeUserLoggedByUserOrderByIdDesc(User user, Pageable pageable);
}
