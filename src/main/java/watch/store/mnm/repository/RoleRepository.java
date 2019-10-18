package watch.store.mnm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import watch.store.mnm.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
