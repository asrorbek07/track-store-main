package uz.pdp.trackstore.dao;

import uz.pdp.trackstore.entity.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewDao {
    boolean insert(Review review);

    List<Review> findAll();

    List<Review> findAllByUserId(UUID userId);

    Review findById(UUID id);
}
