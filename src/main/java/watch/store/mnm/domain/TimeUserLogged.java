package watch.store.mnm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "time_user_logged")
public class TimeUserLogged implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "timeLogged", nullable = false, columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeLogged;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimeLogged() {
        return timeLogged;
    }

    public void setTimeLogged(Date timeLogged) {
        this.timeLogged = timeLogged;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

