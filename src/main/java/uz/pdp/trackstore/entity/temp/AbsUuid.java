package uz.pdp.trackstore.entity.temp;

import java.sql.Date;
import java.util.UUID;

public abstract class AbsUuid {
    private UUID id;
    private Date createdAt;

    public AbsUuid() {
    }

    public AbsUuid(UUID id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
        return "AbsUuid{" +
                "id=" + id +
                ", created_at=" + createdAt +
                '}';
    }
}
