package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.UserDao;
import uz.pdp.trackstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoImpl implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean authenticate(String login, String password) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select password from users where user_name = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            String userPassword = null;
            while (resultSet.next()) {
                userPassword = resultSet.getString(1);
            }
            return password.equals(userPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public boolean insert(User user) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into users(id, user_name, full_name, password, phone_number, email, role_name, active, created_at) VALUES (?,?,?,?,?,?,?,?,?) ;");
            preparedStatement.setObject(1, user.getId());            // id
            preparedStatement.setString(2, user.getUserName());  // user_name
            preparedStatement.setString(3, user.getFullName());         // full_name
            preparedStatement.setString(4, user.getPassword());     // password
            preparedStatement.setString(5, user.getPhoneNumber());     // phone_number
            preparedStatement.setString(6, user.getEmail());       // email
            preparedStatement.setString(7, user.getRoleName());  // role_name
            preparedStatement.setBoolean(8, user.isActive());       // active
            preparedStatement.setDate(9, user.getCreatedAt());       // created_at
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public boolean update(User user) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update users set " +
                            "user_name = ?, " +
                            "full_name = ?, " +
                            "password = ?, " +
                            "phone_number = ?, " +
                            "email = ? where id = ?");
            preparedStatement.setString(1, user.getUserName());// user_name
            preparedStatement.setString(2, user.getFullName());// full_name
            preparedStatement.setString(3, user.getPassword());// password
            preparedStatement.setString(4, user.getPhoneNumber());// phone_number
            preparedStatement.setString(5, user.getEmail());// email
            preparedStatement.setObject(6, user.getId()); //id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public boolean activateOrBlock(UUID userId, boolean isActivating) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update users set " +
                            "active = ? where id = ?");
            preparedStatement.setBoolean(1, isActivating);// active
            preparedStatement.setObject(2, userId);// user_id
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<User> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(UUID.fromString(resultSet.getString(1)));
                user.setUserName(resultSet.getString(2));
                user.setFullName(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setPhoneNumber(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRoleName(resultSet.getString(7));
                user.setActive(resultSet.getBoolean(8));
                user.setCreatedAt(resultSet.getDate(9));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public User findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ? ;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(UUID.fromString(resultSet.getString(1)));
                user.setUserName(resultSet.getString(2));
                user.setFullName(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setPhoneNumber(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRoleName(resultSet.getString(7));
                user.setActive(resultSet.getBoolean(8));
                user.setCreatedAt(resultSet.getDate(9));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public User findByUserName(String userName) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where user_name = ?");
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(UUID.fromString(resultSet.getString(1)));
                user.setUserName(resultSet.getString(2));
                user.setFullName(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setPhoneNumber(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRoleName(resultSet.getString(7));
                user.setActive(resultSet.getBoolean(8));
                user.setCreatedAt(resultSet.getDate(9));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<User> findAllWithoutUser(UUID userId) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id <> ?;");
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(UUID.fromString(resultSet.getString(1)));
                user.setUserName(resultSet.getString(2));
                user.setFullName(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setPhoneNumber(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRoleName(resultSet.getString(7));
                user.setActive(resultSet.getBoolean(8));
                user.setCreatedAt(resultSet.getDate(9));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

}
