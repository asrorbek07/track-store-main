package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class Balance extends AbsUuid {
    private double balance;
    private User userId;

    public Balance() {
    }

    public Balance(UUID id, Date createdAt, double balance, User userId) {
        super(id, createdAt);
        this.balance = balance;
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                ", userId=" + userId +
                '}';
    }
}
