package uz.pdp.trackstore.entity;

import uz.pdp.trackstore.entity.temp.AbsUuid;

import java.sql.Date;
import java.util.UUID;

public class Review extends AbsUuid {
    private String review;
    private Track trackId;

    private User userId;
    private int rate;

    public Review() {
    }

    public Review(UUID id, Date createdAt, String review, Track trackId, User userId, int rate) {
        super(id, createdAt);
        this.review = review;
        this.trackId = trackId;
        this.userId = userId;
        this.rate = rate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Track getTrackId() {
        return trackId;
    }

    public void setTrackId(Track trackId) {
        this.trackId = trackId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review='" + review + '\'' +
                ", trackId=" + trackId +
                ", rate=" + rate +
                '}';
    }
}
