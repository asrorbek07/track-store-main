package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class Album extends AbsUuid {
    private String name;
    private double totalPrice;

    public Album() {
    }

    public Album(UUID id, Date createdAt, String name, double totalPrice) {
        super(id, createdAt);
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
