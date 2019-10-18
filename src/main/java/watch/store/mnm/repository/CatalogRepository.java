package watch.store.mnm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import watch.store.mnm.domain.Catalog;


public interface CatalogRepository extends JpaRepository<Catalog,Integer> {
    Catalog findById(int id);
}
