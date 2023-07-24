package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.OrderDao;
import uz.pdp.trackstore.dao.TrackDao;
import uz.pdp.trackstore.dao.UserDao;
import uz.pdp.trackstore.entity.Order;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderDaoImpl implements OrderDao {
    private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();

    private OrderDaoImpl() {
    }

    public static OrderDaoImpl getInstance() {
        return INSTANCE;
    }

    private final UserDao userDao = UserDaoImpl.getInstance();
    private final TrackDao trackDao = TrackDaoImpl.getInstance();

    @Override
    public boolean insert(Order order) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into orders(id, created_at, order_status, total_price, user_id, track_id) VALUES (?,?,?,?,?,?) ;");
            preparedStatement.setObject(1, order.getId());            // id
            preparedStatement.setDate(2, order.getCreatedAt());       // created_at
            preparedStatement.setString(3, order.getOrderStatus());  // order_status
            preparedStatement.setDouble(4, order.getTotalPrice());         // total_price
            preparedStatement.setObject(5, order.getUserId().getId());         // user_id
            preparedStatement.setObject(6, order.getTrackId().getId());         // track_id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Order> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Order> orderList = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(UUID.fromString(resultSet.getString(1)));
                order.setCreatedAt(resultSet.getDate(2));
                order.setOrderStatus(resultSet.getString(3));
                order.setTotalPrice(resultSet.getDouble(4));
                UUID userId = (UUID) resultSet.getObject(5);
                if (userId != null) {
                    User user = userDao.findById(userId);
                    order.setUserId(user);
                }
                UUID trackId = (UUID) resultSet.getObject(6);
                if (trackId != null) {
                    Track track = trackDao.findById(trackId);
                    order.setTrackId(track);
                }
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Order> findByUserId(UUID userId) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where user_id = ? ;");
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Order> orderList = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(UUID.fromString(resultSet.getString(1)));
                order.setCreatedAt(resultSet.getDate(2));
                order.setOrderStatus(resultSet.getString(3));
                order.setTotalPrice(resultSet.getDouble(4));
                User user = userDao.findById(userId);
                order.setUserId(user);
                UUID trackId = (UUID) resultSet.getObject(6);
                if (trackId != null) {
                    Track track = trackDao.findById(trackId);
                    order.setTrackId(track);
                }
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Order findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where id = ? ;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = new Order();
            while (resultSet.next()) {
                order.setId(UUID.fromString(resultSet.getString(1)));
                order.setCreatedAt(resultSet.getDate(2));
                order.setOrderStatus(resultSet.getString(3));
                order.setTotalPrice(resultSet.getDouble(4));
                UUID userId = (UUID) resultSet.getObject(5);
                if (userId != null) {
                    User user = userDao.findById(userId);
                    order.setUserId(user);
                }
                UUID trackId = (UUID) resultSet.getObject(6);
                if (trackId != null) {
                    Track track = trackDao.findById(trackId);
                    order.setTrackId(track);
                }
            }
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }
}
