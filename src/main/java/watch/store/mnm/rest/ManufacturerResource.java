package watch.store.mnm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.dto.ManufactureDTO;
import watch.store.mnm.service.ManufacturerService;

import java.util.List;

@RestController
public class ManufacturerResource {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping(value = "/manu")
    public @ResponseBody
    List<Manufacturer> findAll(){
        return manufacturerService.getAll();
    }

//    @GetMapping(name = "/manu/paging")
//    public @ResponseBody Page<Manufacturer> getPage( Pageable pageable){
//        return manufacturerService.findPaging(pageable);
//    }


    @PostMapping(value = "/manu")
    public @ResponseBody Manufacturer createManu(@RequestBody ManufactureDTO manufacturer){
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName(manufacturer.getName());
        return manufacturerService.create(manufacturer1);
    }

//    @PostMapping(value = "/manu")
//    public @ResponseBody int createManu1(@RequestBody ManufactureDTO manufacturer){
//        Manufacturer manufacturer1 = new Manufacturer();
//        manufacturer1.setName(manufacturer.getName());
//        return manufacturerService.create1(manufacturer1);
//    }

    @PutMapping(value = "/manu")
    public @ResponseBody Manufacturer updateManu(@RequestBody Manufacturer manufacturer){
        return manufacturerService.update(manufacturer);
    }

    @GetMapping(value = "/manu/{id}")
    public @ResponseBody Manufacturer findById(@PathVariable("id") int id){
        return manufacturerService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody int deleteById(@PathVariable int id){
        return manufacturerService.deleteByIdManu(id);
    }

}

