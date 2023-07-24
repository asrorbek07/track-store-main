package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class User extends AbsUuid {
    private String userName;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String email;
    private String roleName;
    private boolean active;

    public User() {
    }

    public User(UUID id, Date createdAt, String userName, String fullName, String password, String phoneNumber, String email, String roleName) {
        super(id, createdAt);
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", roleName='" + roleName + '\'' +
                ", active=" + active +
                '}';
    }
}
