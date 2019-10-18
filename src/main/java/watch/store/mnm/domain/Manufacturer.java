package watch.store.mnm.domain;

import javax.persistence.*;

@Table(name = "manufacturer")
@Entity
public class Manufacturer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_manufacturer")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer() {
    }

    public Manufacturer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
