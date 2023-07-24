package uz.pdp.trackstore.dao;

import uz.pdp.trackstore.entity.Playlist;

import java.util.List;
import java.util.UUID;

public interface PlaylistDao {
    boolean insert(Playlist playlist);

    List<Playlist> findAll();

    Playlist findById(UUID id);
}
