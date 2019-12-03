package watch.store.mnm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import watch.store.mnm.domain.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    Products findById(int id);
    Products findByName(String name);

//    Page<Products> findAll(Pageable pageable);
}
