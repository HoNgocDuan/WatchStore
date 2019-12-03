package watch.store.mnm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "role")
//@NamedEntityGraph(name = "Role.users",
//        attributeNodes = @NamedAttributeNode("users"))
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public Role(String name) {
        this.name = name;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
}
