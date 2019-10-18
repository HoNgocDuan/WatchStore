package watch.store.mnm.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
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

    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;

    public Set<Account> getAccounts() {
        return accounts;
    }

    public Role(String name) {
        this.name = name;
    }
    public Role() {
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
