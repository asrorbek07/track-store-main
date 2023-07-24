package uz.pdp.trackstore.dao.impl;

import uz.pdp.trackstore.conectionPool.ConnectionPool;
import uz.pdp.trackstore.dao.PlaylistDao;
import uz.pdp.trackstore.dao.TrackDao;
import uz.pdp.trackstore.dao.TrackPlaylistDao;
import uz.pdp.trackstore.entity.Playlist;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.TrackPlaylist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TrackPlaylistDaoImpl implements TrackPlaylistDao {
    private static final TrackPlaylistDaoImpl INSTANCE = new TrackPlaylistDaoImpl();

    private TrackPlaylistDaoImpl() {
    }

    public static TrackPlaylistDaoImpl getInstance() {
        return INSTANCE;
    }

    private final TrackDao trackDao = TrackDaoImpl.getInstance();

    private final PlaylistDao playlistDao = PlaylistDaoImpl.getInstance();

    @Override
    public boolean insert(TrackPlaylist trackPlaylist) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into track_playlist(id, track_id, playlist_id) VALUES (?,?,?) ;");
            preparedStatement.setObject(1, trackPlaylist.getId());            // id
            preparedStatement.setObject(2, trackPlaylist.getTrackId().getId());       // track_id
            preparedStatement.setObject(3, trackPlaylist.getPlaylistId().getId());  // playlist_id

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public List<TrackPlaylist> findAll() {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from track_playlist ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TrackPlaylist> trackPlaylists = new ArrayList<>();
            while (resultSet.next()) {
                TrackPlaylist trackPlaylist = new TrackPlaylist();
                trackPlaylist.setId(UUID.fromString(resultSet.getString(1)));
                UUID track_id = (UUID) resultSet.getObject(2);
                UUID playlist_id = (UUID) resultSet.getObject(3);
                if (track_id != null) {
                    Track track = trackDao.findById(track_id);
                    trackPlaylist.setTrackId(track);
                }
                if (playlist_id != null) {
                    Playlist playlist = playlistDao.findById(playlist_id);
                    trackPlaylist.setPlaylistId(playlist);
                }
                trackPlaylists.add(trackPlaylist);
            }
            return trackPlaylists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }

    @Override
    public TrackPlaylist findById(UUID id) {
        Connection connection = ConnectionPool.getIntance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from track_playlist where id = ? ;");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            TrackPlaylist trackPlaylist = new TrackPlaylist();
            while (resultSet.next()) {
                trackPlaylist.setId(UUID.fromString(resultSet.getString(1)));
                UUID track_id = (UUID) resultSet.getObject(2);
                UUID playlist_id = (UUID) resultSet.getObject(3);
                if (track_id != null) {
                    Track track = trackDao.findById(track_id);
                    trackPlaylist.setTrackId(track);
                }
                if (playlist_id != null) {
                    Playlist playlist = playlistDao.findById(playlist_id);
                    trackPlaylist.setPlaylistId(playlist);
                }
            }
            return trackPlaylist;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getIntance().releaseConnection(connection);
        }
    }
}
