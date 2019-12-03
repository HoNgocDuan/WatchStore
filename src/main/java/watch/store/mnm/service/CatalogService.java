package watch.store.mnm.service;

import watch.store.mnm.domain.Catalog;
import watch.store.mnm.dto.CatalogDTO;

import java.util.List;

public interface CatalogService {

    List<CatalogDTO> getAll();

    //them du lieu
    int create(Catalog catalog);

    int update(Catalog catalog);

    CatalogDTO findById(int id);

    int deleteByIdCata(int id);

    Catalog searchByCata(String name);
}
