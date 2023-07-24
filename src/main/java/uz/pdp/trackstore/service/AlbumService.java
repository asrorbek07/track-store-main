package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.Album;

import java.util.List;
import java.util.UUID;

public interface AlbumService {
    boolean insert(Album album);

    boolean update(Album album);

    List<Album> findAll();

    Album findById(UUID id);
}
