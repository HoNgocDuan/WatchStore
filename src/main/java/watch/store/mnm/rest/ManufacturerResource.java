package watch.store.mnm.rest;

import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.dto.ManufactureDTO;
import watch.store.mnm.service.ManufacturerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ManufacturerResource {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping(value = "/manu")
    public ResponseEntity<List<ManufactureDTO>> findAll() {

        return ResponseEntity.ok().body(manufacturerService.getAll());
    }

//    @GetMapping(name = "/manufacturer/paging",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
//    public @ResponseBody Page<Manufacturer> getPage(Pageable pageable){
//        return manufacturerService.findPaging(pageable);
//    }


    @PostMapping(value = "/manu")
    public @ResponseBody
    Manufacturer createManu(@RequestBody ManufactureDTO manufacturer) {
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName(manufacturer.getName());
        return manufacturerService.create(manufacturer1);
    }


    @PutMapping(value = "/manu")
    public @ResponseBody
    Manufacturer updateManu(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.update(manufacturer);
    }

    @GetMapping(value = "/manu/{id}")
    public @ResponseBody ManufactureDTO findById(@PathVariable("id") int id) {
        return manufacturerService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody int deleteById(@PathVariable int id) {
        return manufacturerService.deleteByIdManu(id);
    }

    @GetMapping(value = "/manu/search/{name}")
    public @ResponseBody Page<Manufacturer> searchNameByManu(@PathVariable String name, Pageable pageable) {
        return manufacturerService.searchNameByManu(name,pageable);
    }

    @GetMapping("/manufacturer/paging")
    public ResponseEntity<Map<Integer,List<ManufactureDTO>>> findPage(@RequestParam("numberPage")int numberPage) {
        MutableInt totalPageMutable = new MutableInt(0);
        Integer totalPage = 0;
        List<ManufactureDTO> manufactureDTOS = manufacturerService.findPage(numberPage, totalPageMutable);
        totalPage = totalPageMutable.getValue();
        Map<Integer,List<ManufactureDTO>> mapUserDto = new HashMap<>();
        mapUserDto.put(totalPage,manufactureDTOS);
        return ResponseEntity.ok().body(mapUserDto);
    }
}

