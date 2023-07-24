package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.PlaylistDao;
import uz.pdp.trackstore.entity.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlaylistDaoImpl implements PlaylistDao {
    private static final PlaylistDaoImpl INSTANCE = new PlaylistDaoImpl();

    private PlaylistDaoImpl() {
    }

    public static PlaylistDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean insert(Playlist playlist) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into playlist(id, created_at, name) VALUES (?,?,?) ;");
            preparedStatement.setObject(1, playlist.getId());            // id
            preparedStatement.setDate(2, playlist.getCreatedAt());       // created_at
            preparedStatement.setString(3, playlist.getName());  // name

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Playlist> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from playlist ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Playlist> playlists = new ArrayList<>();
            while (resultSet.next()) {
                Playlist playlist = new Playlist();
                playlist.setId(UUID.fromString(resultSet.getString(1)));
                playlist.setCreatedAt(resultSet.getDate(2));
                playlist.setName(resultSet.getString(3));
                playlists.add(playlist);
            }
            return playlists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Playlist findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from playlist where id = ? ;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Playlist playlist = new Playlist();
            while (resultSet.next()) {
                playlist.setId(UUID.fromString(resultSet.getString(1)));
                playlist.setCreatedAt(resultSet.getDate(2));
                playlist.setName(resultSet.getString(3));
            }
            return playlist;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }
}
