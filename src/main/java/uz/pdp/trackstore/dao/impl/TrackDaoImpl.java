package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.AlbumDao;
import uz.pdp.trackstore.dao.TrackDao;
import uz.pdp.trackstore.entity.Album;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TrackDaoImpl implements TrackDao {
    private static final TrackDaoImpl INSTANCE = new TrackDaoImpl();

    private TrackDaoImpl() {
    }

    public static TrackDaoImpl getInstance() {
        return INSTANCE;
    }

    private final AlbumDao albumDao = AlbumDaoImpl.getInstance();

    @Override
    public boolean insert(Track track) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into track(id, created_at, name, artist_name, description, genre_name, price, album_id) VALUES (?,?,?,?,?,?,?,?) ;");
            preparedStatement.setObject(1, track.getId());            // id
            preparedStatement.setDate(2, track.getCreatedAt());       // created_at
            preparedStatement.setString(3, track.getName());  // name
            preparedStatement.setString(4, track.getArtistName());         // artist_name
            preparedStatement.setString(5, track.getDescription());     // description
            preparedStatement.setString(6, track.getGenreName());     // genre_name
            preparedStatement.setDouble(7, track.getPrice());       // price
            preparedStatement.setObject(8, track.getAlbumId().getId());  // album_id
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Track> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from track ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Track> trackList = new ArrayList<>();
            while (resultSet.next()) {
                Track track = new Track();
                track.setId(UUID.fromString(resultSet.getString(1)));
                track.setCreatedAt(resultSet.getDate(2));
                track.setName(resultSet.getString(3));
                track.setArtistName(resultSet.getString(4));
                track.setDescription(resultSet.getString(5));
                track.setGenreName(resultSet.getString(6));
                track.setPrice(resultSet.getDouble(7));
                UUID albumId = (UUID) resultSet.getObject(8);
                if (albumId != null) {
                    Album album = albumDao.findById(albumId);
                    track.setAlbumId(album);
                }
                trackList.add(track);
            }
            return trackList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<Track> findAllNotContainsOrder(User current_user) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from track where id not in (select track_id from orders where user_id = ?);");
            preparedStatement.setObject(1, current_user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Track> trackList = new ArrayList<>();
            while (resultSet.next()) {
                Track track = new Track();
                track.setId(UUID.fromString(resultSet.getString(1)));
                track.setCreatedAt(resultSet.getDate(2));
                track.setName(resultSet.getString(3));
                track.setArtistName(resultSet.getString(4));
                track.setDescription(resultSet.getString(5));
                track.setGenreName(resultSet.getString(6));
                track.setPrice(resultSet.getDouble(7));
                UUID albumId = (UUID) resultSet.getObject(8);
                if (albumId != null) {
                    Album album = albumDao.findById(albumId);
                    track.setAlbumId(album);
                }
                trackList.add(track);
            }
            return trackList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public Track findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from track where id = ?;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Track track = new Track();
            while (resultSet.next()) {
                track.setId(UUID.fromString(resultSet.getString(1)));
                track.setCreatedAt(resultSet.getDate(2));
                track.setName(resultSet.getString(3));
                track.setArtistName(resultSet.getString(4));
                track.setDescription(resultSet.getString(5));
                track.setGenreName(resultSet.getString(6));
                track.setPrice(resultSet.getDouble(7));
                UUID albumId = (UUID) resultSet.getObject(8);
                if (albumId != null) {
                    Album album = albumDao.findById(albumId);
                    track.setAlbumId(album);
                }
            }
            return track;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }


}
