package watch.store.mnm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.store.mnm.domain.Catalog;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.dto.CatalogDTO;
import watch.store.mnm.dto.ManufactureDTO;
import watch.store.mnm.repository.CatalogRepository;
import watch.store.mnm.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public List<CatalogDTO> getAll() {
        List<CatalogDTO> listCata = new ArrayList<>();
        List<Catalog> all = catalogRepository.findAll();
        for (Catalog catalog: all) {
            CatalogDTO catalogDTO = new CatalogDTO();
            catalogDTO.setId(catalog.getId());
            catalogDTO.setCatalogName(catalog.getCatalogName());
            catalogDTO.setCatalogDescription(catalog.getCatalogDescription());
            catalogDTO.setCatalogTitle(catalog.getCatalogTitle());
            catalogDTO.setStatus(catalog.getStatus());
            listCata.add(catalogDTO);
        }
        return listCata;
    }

    @Override
    public int create(Catalog catalog) {
        try {
            catalogRepository.save(catalog);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Catalog catalog) {
        try {
            catalogRepository.findById(catalog.getId());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public CatalogDTO findById(int id) {
        CatalogDTO catalogDTO = new CatalogDTO();
        Catalog catalog = catalogRepository.findById(id);
        catalogDTO.setId(catalog.getId());
        catalogDTO.setCatalogName(catalog.getCatalogName());
        catalogDTO.setCatalogTitle(catalog.getCatalogTitle());
        catalogDTO.setCatalogDescription(catalog.getCatalogDescription());
        catalogDTO.setStatus(catalog.getStatus());
        return catalogDTO;
    }

    @Override
    public int deleteByIdCata(int id) {
        try {
            catalogRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Catalog searchByCata(String name) {
        try {
            return catalogRepository.findNameCata(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
