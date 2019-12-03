package watch.store.mnm.dto;

public class CatalogDTO {
    private int id;

    private String catalogName;

    private String catalogTitle;

    private String catalogDescription;

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
