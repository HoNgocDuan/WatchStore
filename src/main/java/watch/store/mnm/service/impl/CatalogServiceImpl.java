package watch.store.mnm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.store.mnm.domain.Catalog;
import watch.store.mnm.repository.CatalogRepository;
import watch.store.mnm.service.CatalogService;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    @Override
    public int create(Catalog catalog) {
        try {
            catalogRepository.save(catalog);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Catalog catalog) {
        try {
            catalogRepository.findById(catalog.getId());
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Catalog findById(int id) {
        return catalogRepository.findById(id);
    }

    @Override
    public int deleteByIdCata(int id) {
        try {
            catalogRepository.deleteById(id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
