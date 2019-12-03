package watch.store.mnm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import watch.store.mnm.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findById(int id);

    Page<User> findAll(Pageable pageable);

//    @Query(value = "from User u")
//    @EntityGraph(value = "User.roles")
//    Page<User> findAllUserAndGetRoles(@Param("name") String name, Pageable pageable);

}

