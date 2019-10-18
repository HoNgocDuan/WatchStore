package watch.store.mnm.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "catalog")
@Entity
public class Catalog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_catalog")
    private String catalogName;

    @Column(name = "title_catalog")
    private String catalogTitle;

    @Column(name = "description_catalog")
    private String catalogDescription;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "status")
    private String status;

    public Catalog() {
    }

    public Catalog(String catalogName, String catalogTitle, String catalogDescription, Date createDate, Date updateDate, String status) {
        this.catalogName = catalogName;
        this.catalogTitle = catalogTitle;
        this.catalogDescription = catalogDescription;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogTitle() {
        return catalogTitle;
    }

    public void setCatalogTitle(String catalogTitle) {
        this.catalogTitle = catalogTitle;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
