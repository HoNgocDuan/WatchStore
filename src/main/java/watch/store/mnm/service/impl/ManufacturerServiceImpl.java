package watch.store.mnm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.repository.ManufacturerRepository;
import watch.store.mnm.service.ManufacturerService;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAll()
    {
        return manufacturerRepository.findAll();
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
    public Manufacturer findById(int id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public int deleteByIdManu(int id) {
        try {
            manufacturerRepository.deleteById(id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();

        }
        return 0;
    }


}

