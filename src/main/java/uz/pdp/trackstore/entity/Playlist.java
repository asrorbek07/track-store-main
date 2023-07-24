package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class Playlist extends AbsUuid {
    private String name;

    public Playlist() {
    }

    public Playlist(UUID id, Date createdAt, String name) {
        super(id, createdAt);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                '}';
    }
}
