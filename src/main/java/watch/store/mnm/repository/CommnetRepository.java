package watch.store.mnm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import watch.store.mnm.domain.Comment;

public interface CommnetRepository extends JpaRepository<Comment,Integer> {

    Comment findByContent(String content);

    Comment findById(int id);

    Page<Comment> findAll(Pageable pageable);


}
