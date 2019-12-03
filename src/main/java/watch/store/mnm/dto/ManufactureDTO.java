package watch.store.mnm.dto;

import watch.store.mnm.domain.Manufacturer;

public class ManufactureDTO {
    private int id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ManufactureDTO(Manufacturer manufacturer) {
        this.id = manufacturer.getId();
        this.name = manufacturer.getName();
    }

    public ManufactureDTO() {
    }
}
