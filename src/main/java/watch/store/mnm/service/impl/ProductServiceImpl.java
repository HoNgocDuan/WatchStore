package watch.store.mnm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.store.mnm.domain.Products;
import watch.store.mnm.dto.ProductDTO;
import watch.store.mnm.repository.ProductRepository;
import watch.store.mnm.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAll() {

        List<ProductDTO> listPro = new ArrayList<>();
        List<Products> all = productRepository.findAll();
        for (Products products: all) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(products.getId());
            productDTO.setName(products.getName());
            productDTO.setPrice(products.getPrice());
            productDTO.setCreateDate(products.getCreateDate());
            productDTO.setDescription(products.getDescription());
            listPro.add(productDTO);
        }
        return listPro;
    }

    @Override
    public Products create(Products products) {
        Products products1 = productRepository.save(products);
        return products1;
    }

    @Override
    public Products update(Products products) {
        Products products1 = productRepository.save(products);
        return products1;
    }

    @Override
    public ProductDTO findById(int id) {
        ProductDTO productDTO = new ProductDTO();
        Products products = productRepository.findById(id);
        productDTO.setId(products.getId());
        productDTO.setName(products.getName());
        productDTO.setCreateDate(products.getCreateDate());
        productDTO.setDescription(products.getDescription());
        productDTO.setDiscount(products.getDiscount());
        productDTO.setImage(products.getImage());
        productDTO.setPrice(products.getPrice());
        productDTO.setTitle(products.getTitle());
        productDTO.setUpdateDate(products.getUpdateDate());
        productDTO.setView(products.getView());
        productDTO.setStatus(products.isStatus());
        return productDTO;
    }

    @Override
    public int deleteByIdPro(int id) {
        try {
            productRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public List<Products> listAll() {
        return productRepository.findAll();
    }
}
