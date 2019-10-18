package watch.store.mnm.service;

import watch.store.mnm.domain.Catalog;

import java.util.List;

public interface CatalogService {

    List<Catalog> getAll();

    //them du lieu
    int create(Catalog catalog);

    int update(Catalog catalog);

    Catalog findById(int id);

    int deleteByIdCata(int id);
}
