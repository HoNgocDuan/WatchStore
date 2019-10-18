package watch.store.mnm.service;

import watch.store.mnm.domain.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    //lay toan bo du lieu
    List<Manufacturer> getAll();

    //phan trang
//    Page<Manufacturer> findPaging(Pageable pageable);

    //them du lieu
    Manufacturer create(Manufacturer manufacturer);

    Manufacturer update(Manufacturer manufacturer);

//    int create1(Manufacturer manufacturer);

    Manufacturer findById(int id);

    int deleteByIdManu(int id);
}
