package watch.store.mnm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import watch.store.mnm.domain.Catalog;
import watch.store.mnm.dto.CatalogDTO;
import watch.store.mnm.service.CatalogService;

import java.util.List;

@RestController
public class CatalogResource {

    @Autowired
    private CatalogService catalogService;

    @GetMapping(value = "/cata")
    public @ResponseBody
    List<Catalog> findAll(){
        return catalogService.getAll();
    }

//    @GetMapping(name = "/manu/paging")
//    public @ResponseBody Page<Manufacturer> getPage( Pageable pageable){
//        return manufacturerService.findPaging(pageable);
//    }


    @PostMapping(value = "/cata")
    public @ResponseBody int createCata(@RequestBody CatalogDTO catalog){
        Catalog catalog1 = new Catalog();
        catalog1.setCatalogName(catalog.getCatalogName());
        catalog1.setCatalogDescription(catalog.getCatalogDescription());
        catalog1.setCatalogTitle(catalog.getCatalogTitle());
        catalog1.setStatus(catalog.getStatus());
        return catalogService.create(catalog1);
    }

    @PutMapping(value = "/cata")
    public @ResponseBody int updateCata(@RequestBody CatalogDTO catalog){
        Catalog catalog1 = new Catalog();
        catalog1.setCatalogName(catalog.getCatalogName());
        catalog1.setCatalogDescription(catalog.getCatalogDescription());
        catalog1.setCatalogTitle(catalog.getCatalogTitle());
        catalog1.setStatus(catalog.getStatus());
        return catalogService.update(catalog1);
    }

    @GetMapping(value = "/cata/{id}")
    public @ResponseBody Catalog findById(@PathVariable("id") int id){
        return catalogService.findById(id);
    }

    @DeleteMapping(value = "cata/delete/{id}")
    public @ResponseBody int deleteById(@PathVariable int id){
        return catalogService.deleteByIdCata(id);
    }
}
