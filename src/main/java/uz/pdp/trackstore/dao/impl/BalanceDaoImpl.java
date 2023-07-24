package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.BalanceDao;
import uz.pdp.trackstore.dao.UserDao;
import uz.pdp.trackstore.entity.Balance;
import uz.pdp.trackstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BalanceDaoImpl implements BalanceDao {
    private static final BalanceDaoImpl INSTANCE = new BalanceDaoImpl();

    private BalanceDaoImpl() {
    }

    public static BalanceDaoImpl getInstance() {
        return INSTANCE;
    }

    private final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public boolean insert(Balance balance) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into balance(id, created_at, balance, user_id) VALUES (?,?,?,?) ;");
            preparedStatement.setObject(1, balance.getId());            // id
            preparedStatement.setDate(2, balance.getCreatedAt());       // created_at
            preparedStatement.setDouble(3, balance.getBalance());  // balance
            preparedStatement.setObject(4, balance.getUserId().getId());         // user_id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public boolean update(Balance balance) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update balance set balance = ? where user_id = ?");
            preparedStatement.setDouble(1, balance.getBalance());// balance
            preparedStatement.setObject(2, balance.getUserId().getId());         // user_id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Balance> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from balance ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Balance> balanceList = new ArrayList<>();
            while (resultSet.next()) {
                Balance balance = new Balance();
                balance.setId(UUID.fromString(resultSet.getString(1)));
                balance.setCreatedAt(resultSet.getDate(2));
                balance.setBalance(resultSet.getDouble(3));
                UUID userId = (UUID) resultSet.getObject(4);
                if (userId != null) {
                    User user = userDao.findById(userId);
                    balance.setUserId(user);
                }
                balanceList.add(balance);
            }
            return balanceList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Balance findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from balance where id = ?;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Balance balance = new Balance();
            while (resultSet.next()) {
                balance.setId(UUID.fromString(resultSet.getString(1)));
                balance.setCreatedAt(resultSet.getDate(2));
                balance.setBalance(resultSet.getDouble(3));
                UUID userId = (UUID) resultSet.getObject(4);
                if (userId != null) {
                    User user = userDao.findById(userId);
                    balance.setUserId(user);
                }
            }
            return balance;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Balance findByUserId(UUID userId) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from balance where user_id = ?;");
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Balance balance = new Balance();
            while (resultSet.next()) {
                balance.setId(UUID.fromString(resultSet.getString(1)));
                balance.setCreatedAt(resultSet.getDate(2));
                balance.setBalance(resultSet.getDouble(3));
                User user = userDao.findById(userId);
                balance.setUserId(user);
            }
            return balance;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }
}
