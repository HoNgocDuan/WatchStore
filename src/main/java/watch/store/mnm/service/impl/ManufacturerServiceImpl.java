package watch.store.mnm.service.impl;

import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import watch.store.mnm.component.AccountSeeding;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.dto.ManufactureDTO;
import watch.store.mnm.repository.ManufacturerRepository;
import watch.store.mnm.service.ManufacturerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<ManufactureDTO> getAll() {
        List<ManufactureDTO> listManu = new ArrayList<>();
        List<Manufacturer> all = manufacturerRepository.findAll();
        for (Manufacturer manufacturer: all) {
          ManufactureDTO manufactureDTO = new ManufactureDTO();
          manufactureDTO.setId(manufacturer.getId());
          manufactureDTO.setName(manufacturer.getName());
          listManu.add(manufactureDTO);
        }
        return listManu;
    }

    @Override
    public Page<Manufacturer> findPaging(Pageable pageable) {
        try {
            return manufacturerRepository.findAll(pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ManufactureDTO findById(int id) {
        ManufactureDTO manu = new ManufactureDTO();
        Manufacturer manufacturer = manufacturerRepository.findById(id);
        manu.setId(manufacturer.getId());
        manu.setName(manufacturer.getName());
        return manu;
    }

//    @Override
//    public Page<Manufacturer> findPaging(Pageable pageable) {
//        return manufacturerRepository.findAll(pageable);
//    }

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        Manufacturer manufacturer1 = manufacturerRepository.save(manufacturer);
        return manufacturer1;
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        Manufacturer manufacturer1 = manufacturerRepository.save(manufacturer);
        return manufacturer1;
    }

//    @Override
//    public int create1(Manufacturer manufacturer) {
//        try {
//            manufacturerRepository.save(manufacturer);
//            return 1;
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }



    @Override
    public int deleteByIdManu(int id) {
        try {
            manufacturerRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public Page<Manufacturer> searchNameByManu(String name, Pageable pageable) {
        try {
            return manufacturerRepository.findNameManu(name,pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ManufactureDTO> findPage(int numberPage, MutableInt totalPages) {
        Page<Manufacturer> manusPage = manufacturerRepository.findPage(PageRequest.of(numberPage, 5));
        List<Manufacturer> manufacturers = manusPage.getContent();
        List<ManufactureDTO> manuDTOs = new ArrayList<>();
        totalPages.setValue(manusPage.getTotalPages());
        for (Manufacturer manufacturer : manufacturers) {
            ManufactureDTO manufactureDTO = new ManufactureDTO(manufacturer);
            manuDTOs.add(manufactureDTO);
        }
        return manuDTOs;
    }


}

