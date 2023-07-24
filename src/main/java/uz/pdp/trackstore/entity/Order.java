package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class Order extends AbsUuid {
    private String orderStatus;
    private double totalPrice;
    private User userId;

    private Track trackId;

    public Order() {
    }

    public Order(UUID id, Date createdAt, String orderStatus, double totalPrice, User userId, Track trackId) {
        super(id, createdAt);
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.trackId = trackId;
    }

    public Track getTrackId() {
        return trackId;
    }

    public void setTrackId(Track trackId) {
        this.trackId = trackId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderStatus='" + orderStatus + '\'' +
                ", totalPrice=" + totalPrice +
                ", userId=" + userId +
                ", trackId=" + trackId +
                '}';
    }
}
