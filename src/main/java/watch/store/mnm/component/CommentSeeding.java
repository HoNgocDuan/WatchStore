package watch.store.mnm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import watch.store.mnm.domain.*;
import watch.store.mnm.repository.CommnetRepository;
import watch.store.mnm.repository.ProductRepository;
import watch.store.mnm.repository.UserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class CommentSeeding implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private CommnetRepository commnetRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (commnetRepository.findByContent("Tuyet voi") == null) {
            Comment comment = new Comment();
            comment.setContent("Tuyet voi");
            comment.setCreateDate(new Date(System.currentTimeMillis()));
            comment.setStatus("1");

            Set<Products> setPro = new HashSet<>();
            setPro.add(productRepository.findByName("Acer230"));
            comment.setProducts(setPro);

            Set<User> setUser = new HashSet<>();
            setUser.add(userRepository.findByUsername(AccountSeeding.ROLE_EMPLOYEE));
            comment.setUsers(setUser);

            commnetRepository.save(comment);
        }
    }
}
