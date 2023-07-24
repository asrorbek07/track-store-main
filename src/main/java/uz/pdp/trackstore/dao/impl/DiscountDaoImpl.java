package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.DiscountDao;
import uz.pdp.trackstore.dao.UserDao;
import uz.pdp.trackstore.entity.Discount;
import uz.pdp.trackstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DiscountDaoImpl implements DiscountDao {
    private static final DiscountDaoImpl INSTANCE = new DiscountDaoImpl();

    private DiscountDaoImpl() {
    }

    public static DiscountDaoImpl getInstance() {
        return INSTANCE;
    }

    private final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public boolean insert(Discount discount) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into discount(id, created_at, percentage, user_id) VALUES (?,?,?,?) ;");
            preparedStatement.setObject(1, discount.getId());            // id
            preparedStatement.setDate(2, discount.getCreatedAt());       // created_at
            preparedStatement.setDouble(3, discount.getPercentage());  // percentage
            preparedStatement.setObject(4, discount.getUserId().getId());         // user_id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Discount> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from balance ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Discount> discountList = new ArrayList<>();
            while (resultSet.next()) {
                Discount discount = new Discount();
                discount.setId(UUID.fromString(resultSet.getString(1)));
                discount.setCreatedAt(resultSet.getDate(2));
                discount.setPercentage(resultSet.getDouble(3));
                UUID userId = (UUID) resultSet.getObject(4);
                if (userId != null) {
                    User user = userDao.findById(userId);
                    discount.setUserId(user);
                }
                discountList.add(discount);
            }
            return discountList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Discount findByUserId(UUID userId) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from discount where user_id = ?;");
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Discount discount = new Discount();
            while (resultSet.next()) {
                discount.setId(UUID.fromString(resultSet.getString(1)));
                discount.setCreatedAt(resultSet.getDate(2));
                discount.setPercentage(resultSet.getDouble(3));
                User user = userDao.findById(userId);
                discount.setUserId(user);
            }
            return discount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Discount findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from discount where id = ?;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Discount discount = new Discount();
            while (resultSet.next()) {
                discount.setId(UUID.fromString(resultSet.getString(1)));
                discount.setCreatedAt(resultSet.getDate(2));
                discount.setPercentage(resultSet.getDouble(3));
                UUID userId = (UUID) resultSet.getObject(4);
                if (userId != null) {
                    User user = userDao.findById(userId);
                    discount.setUserId(user);
                }
            }
            return discount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }
}
