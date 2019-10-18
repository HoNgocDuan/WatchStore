package watch.store.mnm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import watch.store.mnm.domain.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}
