package watch.store.mnm.service;

import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.dto.ManufactureDTO;

import java.util.List;

public interface ManufacturerService {

    //lay toan bo du lieu
    List<ManufactureDTO> getAll();

 //   phan trang
    Page<Manufacturer> findPaging(Pageable pageable);

    //them du lieu
    Manufacturer create(Manufacturer manufacturer);

    Manufacturer update(Manufacturer manufacturer);

//    int create1(Manufacturer manufacturer);

    ManufactureDTO findById(int id);

    int deleteByIdManu(int id);

    Page<Manufacturer> searchNameByManu(String name, Pageable pageable);

    List<ManufactureDTO> findPage(int numberPage, MutableInt totalPages);
}
