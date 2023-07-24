package uz.pdp.trackstore.dao;

import uz.pdp.trackstore.entity.TrackPlaylist;

import java.util.List;
import java.util.UUID;

public interface TrackPlaylistDao {
    boolean insert(TrackPlaylist trackPlaylist);

    List<TrackPlaylist> findAll();

    TrackPlaylist findById(UUID id);
}
