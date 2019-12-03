package watch.store.mnm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.dto.ManufactureDTO;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    Manufacturer findById(int id);

    Page<Manufacturer> findAll(Pageable pageable);

    Manufacturer findByName(String name);

    @Query(value = "SELECT * FROM manufacturer WHERE name_manufacturer LIKE %:name%", nativeQuery = true)
    Page<Manufacturer> findNameManu(@Param("name") String name, Pageable pageable);

    @Query(value = "from Manufacturer manu")
    Page<Manufacturer> findPage(Pageable pageable);

}
