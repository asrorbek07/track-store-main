package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.ReviewDao;
import uz.pdp.trackstore.dao.impl.ReviewDaoImpl;
import uz.pdp.trackstore.entity.Review;
import uz.pdp.trackstore.service.ReviewService;

import java.util.List;
import java.util.UUID;

public class ReviewServiceImpl implements ReviewService {
    private static final ReviewServiceImpl INSTANCE = new ReviewServiceImpl();

    private ReviewServiceImpl() {
    }

    public static ReviewServiceImpl getInstance() {
        return INSTANCE;
    }
    private final ReviewDao reviewDao = ReviewDaoImpl.getInstance();

    @Override
    public boolean insert(Review review) {
        return reviewDao.insert(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public List<Review> findAllByUserId(UUID userId) {
        return reviewDao.findAllByUserId(userId);
    }

    @Override
    public Review findById(UUID id) {
        return reviewDao.findById(id);
    }
}
