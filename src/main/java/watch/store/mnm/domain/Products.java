//package watch.store.mnm.domain;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "products")
//public class Products {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    @ManyToMany
//    @JoinTable(name = "id_catalog",
//            joinColumns = @JoinColumn(name = "id_product"),
//            inverseJoinColumns = @JoinColumn(name = "id_catalog"))
//    private int id_catalog;
//
//    @Column(name = "name_product")
//    private String name;
//
//    @Column(name = "price")
//    private double price;
//
//    @Column(name = "discount")
//    private float discount;
//
//    @Column(name = "status")
//    private boolean status;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "image")
//    private String image;
//
//    @ManyToMany
//    @JoinTable(name = "id_catalog",
//            joinColumns = @JoinColumn(name = "id_product"),
//            inverseJoinColumns = @JoinColumn(name = "id_manu"))
//    private int id_manu;
//
//    @Column(name = "view")
//    private int view;
//
//    @Column(name = "create_date")
//    private Date createDate;
//
//    @Column(name = "update_date")
//    private Date updateDate;
//
//}
