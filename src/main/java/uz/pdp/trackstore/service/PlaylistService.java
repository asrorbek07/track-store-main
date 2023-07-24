package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.Playlist;

import java.util.List;
import java.util.UUID;

public interface PlaylistService {
    boolean insert(Playlist playlist);

    List<Playlist> findAll();

    Playlist findById(UUID id);
}
