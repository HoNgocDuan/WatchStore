package watch.store.mnm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import watch.store.mnm.domain.Catalog;
import watch.store.mnm.domain.Manufacturer;
import watch.store.mnm.domain.Products;
import watch.store.mnm.domain.Role;
import watch.store.mnm.repository.CatalogRepository;
import watch.store.mnm.repository.ManufacturerRepository;
import watch.store.mnm.repository.ProductRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class SanPhamSeeding implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CatalogRepository catalogRepository;

    //manufacturer
    public static final String Rolex = "Rolex";
    public static final String SamSung = "SamSung";
    public static final String Casino = "Casino";
    public static final String Apple = "Apple";

    //catalog
    private static final String DongHoNam = "DongHoNam";
    private static final String DongHoNu = "DongHoNu";
    private static final String DongHoDoi = "DongHoDoi";

    //products
    private static final String Pro_Rolex = "Acer23" ;
    private static final String Pro_SamSung = "SamSung1";
    private static final String Pro_Casino = "Casino1";
    private static final String Pro_Apple = "Apple1";


    public static final String PATH_DEFAULT_IMAGE = "static/assets/img/angular.png";


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //manufacturer
        if (manufacturerRepository.findByName(Rolex) == null) {
            manufacturerRepository.save(new Manufacturer(Rolex));
        }
        if (manufacturerRepository.findByName(SamSung) == null) {
            manufacturerRepository.save(new Manufacturer(SamSung));
        }
        if (manufacturerRepository.findByName(Casino) == null) {
            manufacturerRepository.save(new Manufacturer(Casino));
        }
        if (manufacturerRepository.findByName(Apple) == null) {
            manufacturerRepository.save(new Manufacturer(Apple));
        }

        if(catalogRepository.findByCatalogName(DongHoDoi) == null){
            Catalog catalog = new Catalog();
            catalog.setCatalogName("Acer1");
            catalog.setCatalogDescription("Day la dong ho rolex");
            catalog.setCatalogTitle("Day la dong ho");
            catalog.setCreateDate(new Date(System.currentTimeMillis()));
            catalog.setUpdateDate(new Date(System.currentTimeMillis()));
            catalog.setStatus("1");

            catalogRepository.save(catalog);
        }

        if(catalogRepository.findByCatalogName(DongHoNam) == null){
            Catalog catalog1 = new Catalog();
            catalog1.setCatalogName("Acer2");
            catalog1.setCatalogDescription("Day la dong ho Sam Sung");
            catalog1.setCatalogTitle("Day la dong ho");
            catalog1.setCreateDate(new Date(System.currentTimeMillis()));
            catalog1.setUpdateDate(new Date(System.currentTimeMillis()));
            catalog1.setStatus("1");
            catalogRepository.save(catalog1);
        }

        if(catalogRepository.findByCatalogName(DongHoNu) == null){
            Catalog catalog2 = new Catalog();
            catalog2.setCatalogName("Acer3");
            catalog2.setCatalogDescription("Day la dong ho Sam Sung");
            catalog2.setCatalogTitle("Day la dong ho");
            catalog2.setCreateDate(new Date(System.currentTimeMillis()));
            catalog2.setUpdateDate(new Date(System.currentTimeMillis()));
            catalog2.setStatus("1");
            catalogRepository.save(catalog2);
        }

        if(catalogRepository.findByCatalogName(DongHoNam) == null){
            Catalog catalog3 = new Catalog();
            catalog3.setCatalogName("Acer4");
            catalog3.setCatalogDescription("Day la dong ho Acer 4");
            catalog3.setCatalogTitle("Day la dong ho");
            catalog3.setCreateDate(new Date(System.currentTimeMillis()));
            catalog3.setUpdateDate(new Date(System.currentTimeMillis()));
            catalog3.setStatus("1");
            catalogRepository.save(catalog3);
        }

        if(catalogRepository.findByCatalogName(DongHoNam) == null){
            Catalog catalog4 = new Catalog();
            catalog4.setCatalogName("Acer5");
            catalog4.setCatalogDescription("Day la dong ho Acer5");
            catalog4.setCatalogTitle("Day la dong ho");
            catalog4.setCreateDate(new Date(System.currentTimeMillis()));
            catalog4.setUpdateDate(new Date(System.currentTimeMillis()));
            catalog4.setStatus("1");
            catalogRepository.save(catalog4);
        }

        for (int i = 0; i <10 ; i ++){
            if (productRepository.findByName(Pro_Rolex) == null) {
                Products products = new Products();
                products.setName(Pro_Rolex + i);
                products.setCreateDate(new Date(System.currentTimeMillis()));
                products.setDescription("abc");
                products.setDiscount(10);
                try {
                    File file = new ClassPathResource(PATH_DEFAULT_IMAGE).getFile();
                    byte[] imgByte = new byte[(int) file.length()];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(imgByte);
                    products.setImage(imgByte);
                } catch (IOException ex) {

                }
                products.setPrice(10);
                products.setStatus(true);
                products.setTitle("abc");
                products.setUpdateDate(new Date(System.currentTimeMillis()));
                products.setView(100);

                Set<Manufacturer> setManu = new HashSet<>();
                setManu.add(manufacturerRepository.findByName(SamSung));
                products.setManufacturers(setManu);

                Set<Catalog> setCata = new HashSet<>();
                setCata.add(catalogRepository.findByCatalogName("Acer1"));
                products.setCatalogs(setCata);

                productRepository.save(products);
            }
        }

    }
}
