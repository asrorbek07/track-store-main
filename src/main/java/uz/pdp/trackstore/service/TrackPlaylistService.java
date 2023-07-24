package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.TrackPlaylist;

import java.util.List;
import java.util.UUID;

public interface TrackPlaylistService {
    boolean insert(TrackPlaylist trackPlaylist);

    List<TrackPlaylist> findAll();

    TrackPlaylist findById(UUID id);
}
