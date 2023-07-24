package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class Discount extends AbsUuid {
    private double percentage;
    private User userId;

    public Discount() {
    }

    public Discount(UUID id, Date createdAt, Integer percentage, User userId) {
        super(id, createdAt);
        this.percentage = percentage;
        this.userId = userId;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "percentage=" + percentage +
                ", userId=" + userId +
                '}';
    }
}
