package watch.store.mnm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import watch.store.mnm.domain.Account;
import watch.store.mnm.domain.Role;
import watch.store.mnm.repository.AccountRepository;
import watch.store.mnm.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class AccountSeeding implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AccountRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String ROLE_ADMIN = "ROLE_ADMIN";


    private static final String USERNAME_ADMIN = "HoNgocDuan";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // add roles if role not exists
        if(roleRepository.findByName(ROLE_ADMIN)==null) {
            roleRepository.save(new Role(ROLE_ADMIN));
        }

        // add user if user not exists
        //admin
        if(userRepository.findByUsername(USERNAME_ADMIN)==null) {
            Account user = new Account();
            user.setUsername(USERNAME_ADMIN);

            user.setFirstname("Duan");
            user.setLastname("Ho");
            user.setPassword(passwordEncoder.encode("ninhbinh123"));

            Set<Role> setRole = new HashSet<>();
            setRole.add(roleRepository.findByName(ROLE_ADMIN));
            user.setRolse(setRole);
            userRepository.save(user);
        }

    }
}
