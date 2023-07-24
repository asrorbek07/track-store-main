package uz.pdp.trackstore.dao;

import uz.pdp.trackstore.entity.Album;

import java.util.List;
import java.util.UUID;

public interface AlbumDao {
    boolean insert(Album album);

    boolean update(Album album);

    List<Album> findAll();

    Album findById(UUID id);
}
