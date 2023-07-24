package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class Track extends AbsUuid {
    private String name;
    private String artistName;
    private String description;
    private String genreName;
    private double price;
    private Album albumId;

    public Track() {
    }

    public Track(UUID id, Date createdAt, String name, String artistName, String description, String genreName, double price, Album albumId) {
        super(id, createdAt);
        this.name = name;
        this.artistName = artistName;
        this.description = description;
        this.genreName = genreName;
        this.price = price;
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Album getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Album albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", description='" + description + '\'' +
                ", genreName='" + genreName + '\'' +
                ", price=" + price +
                ", albumId=" + albumId +
                '}';
    }
}
