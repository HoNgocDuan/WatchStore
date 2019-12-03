package watch.store.mnm.service;


import watch.store.mnm.domain.Products;
import watch.store.mnm.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    //lay toan bo du lieu
    List<ProductDTO> getAll();

    //phan trang
//    Page<Manufacturer> findPaging(Pageable pageable);

    //them du lieu
    Products create(Products products);

    Products update(Products products);


    ProductDTO findById(int id);

    int deleteByIdPro(int id);

    List<Products> listAll();
}
