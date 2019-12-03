package watch.store.mnm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "manufacturer")
@Entity
public class Manufacturer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_manufacturer")
    private String name;

    @ManyToMany(mappedBy = "manufacturers")
    private Set<Products> products;

    public Manufacturer() {
    }

    public Manufacturer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Manufacturer(String name) {
        this.name = name;
    }

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

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
