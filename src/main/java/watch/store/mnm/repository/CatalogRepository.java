package watch.store.mnm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import watch.store.mnm.domain.Catalog;


public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    Catalog findById(int id);
    Catalog findByCatalogName(String name);

    Page<Catalog> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM catalog where name_catalog LIKE %:name%", nativeQuery = true)
    Catalog findNameCata(@Param("name") String name);

    Catalog findByCatalogNameLike(String name);
}
