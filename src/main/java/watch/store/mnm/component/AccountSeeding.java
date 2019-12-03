package watch.store.mnm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import watch.store.mnm.domain.User;
import watch.store.mnm.domain.Role;
import watch.store.mnm.repository.RoleRepository;
import watch.store.mnm.repository.UserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class AccountSeeding implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";
    public static final String ROLE_ACCOUNTANT = "ROLE_ACCOUNTANT";
    public static final String ROLE_CASHIER = "ROLE_CASHIER";

    private static final String USERNAME_ADMIN = "HoNgocDuan";
    private static final String USERNAME_EMPLOYEE = "DiepVanTrung";
    private static final String USERNAME_ACCOUNTANT = "NongVietAnh";
    private static final String USERNAME_CASHIER = "NguyenThaoMy";

    public static final String PATH_DEFAULT_IMAGE = "static/assets/img/angular.png";
    public static final String PASSWORD_DEFAULT = "123456";


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // add roles if role not exists
        if (roleRepository.findByName(ROLE_ADMIN) == null) {
            roleRepository.save(new Role(ROLE_ADMIN));
        }
        if (roleRepository.findByName(ROLE_ACCOUNTANT) == null) {
            roleRepository.save(new Role(ROLE_ACCOUNTANT));
        }
        if (roleRepository.findByName(ROLE_CASHIER) == null) {
            roleRepository.save(new Role(ROLE_CASHIER));
        }
        if (roleRepository.findByName(ROLE_EMPLOYEE) == null) {
            roleRepository.save(new Role(ROLE_EMPLOYEE));
        }
        // add user if user not exists
        //admin
        if (userRepository.findByUsername(USERNAME_ADMIN) == null) {
            User user = new User();
            user.setUsername(USERNAME_ADMIN);
            user.setEmail("buiquanglinh.291298@gmail.com");
            user.setCreateBy("SYSTEM");
            user.setFirstname("Duan");
            user.setLastname("Ho");
            user.setFaceBookUrl("https://www.facebook.com/LinhBui.IT");
            user.setPassword(passwordEncoder.encode(PASSWORD_DEFAULT));
            user.setBirthDate(new Date(0));
            user.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
            try {
                File file = new ClassPathResource(PATH_DEFAULT_IMAGE).getFile();
                byte[] imgByte = new byte[(int) file.length()];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(imgByte);
                user.setImage(imgByte);
            } catch (IOException ex) {

            }
            Set<Role> setRole = new HashSet<>();
            setRole.add(roleRepository.findByName(ROLE_ADMIN));
//            setRole.add(roleRepository.findByName(ROLE_EMPLOYEE));
//            setRole.add(roleRepository.findByName(ROLE_ACCOUNTANT));
//            setRole.add(roleRepository.findByName(ROLE_CASHIER));
            user.setRoles(setRole);
            userRepository.save(user);
        }
        //accountant
        if (userRepository.findByUsername(USERNAME_ACCOUNTANT) == null) {
            User accountant = new User();
            accountant.setUsername(USERNAME_ACCOUNTANT);
            accountant.setEmail("kieuvanhanh@gmail.com");
            accountant.setCreateBy("SYSTEM");
            accountant.setFirstname("Diep");
            accountant.setLastname("Trung");
            accountant.setPassword(passwordEncoder.encode(PASSWORD_DEFAULT));
            accountant.setBirthDate(new Date(1));
            accountant.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
            try {
                File file = new ClassPathResource(PATH_DEFAULT_IMAGE).getFile();
                byte[] imgByte = new byte[(int) file.length()];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(imgByte);
                accountant.setImage(imgByte);
            } catch (IOException ex) {

            }
            Set<Role> setRole = new HashSet<>();
            setRole.add(roleRepository.findByName(ROLE_ACCOUNTANT));
            accountant.setRoles(setRole);
            userRepository.save(accountant);
        }
        //cashier
        if (userRepository.findByUsername(USERNAME_CASHIER) == null) {
            User cashier = new User();
            cashier.setUsername(USERNAME_CASHIER);
            cashier.setEmail("hoduyhuy@gmail.com");
            cashier.setCreateBy("SYSTEM");
            cashier.setFirstname("Nong");
            cashier.setLastname("Viet Anh");
            cashier.setPassword(passwordEncoder.encode(PASSWORD_DEFAULT));
            cashier.setBirthDate(new Date(2));
            cashier.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
            try {
                File file = new ClassPathResource(PATH_DEFAULT_IMAGE).getFile();
                byte[] imgByte = new byte[(int) file.length()];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(imgByte);
                cashier.setImage(imgByte);
            } catch (IOException ex) {

            }
            Set<Role> setRole = new HashSet<>();
            setRole.add(roleRepository.findByName(ROLE_CASHIER));
            cashier.setRoles(setRole);
            userRepository.save(cashier);
        }
        //employee
        if (userRepository.findByUsername(USERNAME_EMPLOYEE) == null) {
            User employee = new User();
            employee.setUsername(USERNAME_EMPLOYEE);
            employee.setEmail("nguyenthaomy@gmail.com");
            employee.setCreateBy("SYSTEM");
            employee.setFirstname("thao");
            employee.setLastname("my");
            employee.setPassword(passwordEncoder.encode(PASSWORD_DEFAULT));
            employee.setBirthDate(new Date(0));
            employee.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
            try {
                File file = new ClassPathResource(PATH_DEFAULT_IMAGE).getFile();
                byte[] imgByte = new byte[(int) file.length()];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(imgByte);
                employee.setImage(imgByte);
            } catch (IOException ex) {

            }
            Set<Role> setRole = new HashSet<>();
            setRole.add(roleRepository.findByName(ROLE_EMPLOYEE));
            employee.setRoles(setRole);
            userRepository.save(employee);
        }

    }
}