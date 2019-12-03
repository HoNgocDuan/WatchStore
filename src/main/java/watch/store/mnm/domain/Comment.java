package watch.store.mnm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Table(name = "comment")
@Entity
public class Comment implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "commet_user",
            joinColumns = @JoinColumn(name = "commet_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "comment_products",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Products> products;

    @Column(name = "content")
    private String content;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
