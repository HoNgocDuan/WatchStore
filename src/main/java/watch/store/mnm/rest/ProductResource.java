package watch.store.mnm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import watch.store.mnm.domain.Products;
import watch.store.mnm.dto.ManufactureDTO;
import watch.store.mnm.dto.ProductDTO;
import watch.store.mnm.service.ProductService;

import java.util.List;

@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public ResponseEntity<List<ProductDTO>> findAll() {

        return ResponseEntity.ok().body(productService.getAll());
    }

//    @GetMapping(name = "/manu/paging")
//    public @ResponseBody Page<Manufacturer> getPage( Pageable pageable){
//        return manufacturerService.findPaging(pageable);
//    }


    @PostMapping(value = "/product")
    public @ResponseBody
    Products createPro(@RequestBody ProductDTO productDTO) {
        Products products = new Products();
        products.setName(productDTO.getName());
        return productService.create(products);
    }


    @PutMapping(value = "/product")
    public @ResponseBody
    Products updatePro(@RequestBody Products products) {
        return productService.update(products);
    }

    @GetMapping(value = "/product/{id}")
    public @ResponseBody ProductDTO findById(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @DeleteMapping(value = "product/delete/{id}")
    public @ResponseBody int deleteById(@PathVariable int id) {
        return productService.deleteByIdPro(id);
    }
}
