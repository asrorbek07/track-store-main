package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.AlbumDao;
import uz.pdp.trackstore.entity.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AlbumDaoImpl implements AlbumDao {
    private static final AlbumDaoImpl INSTANCE = new AlbumDaoImpl();

    private AlbumDaoImpl() {
    }

    public static AlbumDaoImpl getInstance() {
        return INSTANCE;
    }


    @Override
    public boolean insert(Album album) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into album(id, created_at, name, total_price) VALUES (?,?,?,?) ;");
            preparedStatement.setObject(1, album.getId());            // id
            preparedStatement.setDate(2, album.getCreatedAt());       // created_at
            preparedStatement.setString(3, album.getName());  // name
            preparedStatement.setDouble(4, album.getTotalPrice());         // total_price

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public boolean update(Album album) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update album set total_price = ? where id = ?");
            preparedStatement.setDouble(1, album.getTotalPrice());// total_price
            preparedStatement.setObject(2, album.getId());         // id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Album> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from album ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Album> albumList = new ArrayList<>();
            while (resultSet.next()) {
                Album album = new Album();
                album.setId(UUID.fromString(resultSet.getString(1)));
                album.setCreatedAt(resultSet.getDate(2));
                album.setName(resultSet.getString(3));
                album.setTotalPrice(resultSet.getDouble(4));
                albumList.add(album);
            }
            return albumList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Album findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from album where id = ?;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Album album = new Album();
            while (resultSet.next()) {
                album.setId(UUID.fromString(resultSet.getString(1)));
                album.setCreatedAt(resultSet.getDate(2));
                album.setName(resultSet.getString(3));
                album.setTotalPrice(resultSet.getDouble(4));
            }
            return album;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }
}
