package webautomationx;

import java.util.Date;

public class Response {

    long id;
    Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "webautomationx.Response [ id=" + id + ", createdAt=" + createdAt + " ]";
    }
}
