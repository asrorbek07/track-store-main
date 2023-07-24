package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.ReviewDao;
import uz.pdp.trackstore.dao.TrackDao;
import uz.pdp.trackstore.dao.UserDao;
import uz.pdp.trackstore.entity.Review;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReviewDaoImpl implements ReviewDao {
    private static final ReviewDaoImpl INSTANCE = new ReviewDaoImpl();

    private ReviewDaoImpl() {
    }

    public static ReviewDaoImpl getInstance() {
        return INSTANCE;
    }

    private final TrackDao trackDao = TrackDaoImpl.getInstance();

    private final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public boolean insert(Review review) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into review(id, created_at, review, rate, track_id, user_id) VALUES (?,?,?,?,?,?) ;");
            preparedStatement.setObject(1, review.getId());            // id
            preparedStatement.setDate(2, review.getCreatedAt());       // created_at
            preparedStatement.setString(3, review.getReview());  // review
            preparedStatement.setInt(4, review.getRate());         // rate
            preparedStatement.setObject(5, review.getTrackId().getId());         // track_id
            preparedStatement.setObject(6, review.getUserId().getId());         // user_id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Review> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from review");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Review> reviewList = new ArrayList<>();
            while (resultSet.next()) {
                Review review = new Review();
                review.setId(UUID.fromString(resultSet.getString(1)));
                review.setCreatedAt(resultSet.getDate(2));
                review.setReview(resultSet.getString(3));
                review.setRate(resultSet.getInt(4));
                UUID track_id = (UUID) resultSet.getObject(5);
                if (track_id != null) {
                    Track track = trackDao.findById(track_id);
                    review.setTrackId(track);
                }
                UUID user_id = (UUID) resultSet.getObject(6);
                if (user_id != null) {
                    User user = userDao.findById(user_id);
                    review.setUserId(user);
                }
                reviewList.add(review);
            }
            return reviewList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Review> findAllByUserId(UUID userId) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from review where user_id = ?;");
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Review> reviewList = new ArrayList<>();
            while (resultSet.next()) {
                Review review = new Review();
                review.setId(UUID.fromString(resultSet.getString(1)));
                review.setCreatedAt(resultSet.getDate(2));
                review.setReview(resultSet.getString(3));
                review.setRate(resultSet.getInt(4));
                UUID track_id = (UUID) resultSet.getObject(5);
                if (track_id != null) {
                    Track track = trackDao.findById(track_id);
                    review.setTrackId(track);
                }
                UUID user_id = (UUID) resultSet.getObject(6);
                if (user_id != null) {
                    User user = userDao.findById(user_id);
                    review.setUserId(user);
                }
                reviewList.add(review);
            }
            return reviewList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Review findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from review where id = ? ;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Review review = new Review();
            while (resultSet.next()) {
                review.setId(UUID.fromString(resultSet.getString(1)));
                review.setCreatedAt(resultSet.getDate(2));
                review.setReview(resultSet.getString(3));
                review.setRate(resultSet.getInt(4));
                UUID track_id = (UUID) resultSet.getObject(5);
                if (track_id != null) {
                    Track track = trackDao.findById(track_id);
                    review.setTrackId(track);
                }
                UUID user_id = (UUID) resultSet.getObject(6);
                if (user_id != null) {
                    User user = userDao.findById(user_id);
                    review.setUserId(user);
                }
            }
            return review;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }
}
