package watch.store.mnm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import watch.store.mnm.domain.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    Manufacturer findById(int id);
//    Page<Manufacturer> findAll(Pageable pageable);
}
