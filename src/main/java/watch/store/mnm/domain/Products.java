package watch.store.mnm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "products")
@NamedEntityGraph(name = "Product.catalogs",
        attributeNodes = @NamedAttributeNode("catalogs"))
@NamedEntityGraph(name = "Product.manufacturers",
        attributeNodes = @NamedAttributeNode("manufacturers"))
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_cata",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cata_id"))
    private Set<Catalog> catalogs;

    @Column(name = "name_product")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private float discount;

    @Column(name = "status")
    private boolean status;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_manu",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "manu_id"))
    private Set<Manufacturer> manufacturers;

    @Column(name = "view")
    private int view;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToMany(mappedBy = "products")
    private Set<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(Set<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
