package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.AlbumDao;
import uz.pdp.trackstore.dao.impl.AlbumDaoImpl;
import uz.pdp.trackstore.entity.Album;
import uz.pdp.trackstore.service.AlbumService;

import java.util.List;
import java.util.UUID;

public class AlbumServiceImpl implements AlbumService {
    private static final AlbumServiceImpl INSTANCE = new AlbumServiceImpl();

    private AlbumServiceImpl() {
    }

    public static AlbumServiceImpl getInstance() {
        return INSTANCE;
    }

    private final AlbumDao albumDao = AlbumDaoImpl.getInstance();

    @Override
    public boolean insert(Album album) {
        return albumDao.insert(album);
    }

    @Override
    public boolean update(Album album) {
        return albumDao.update(album);
    }

    @Override
    public List<Album> findAll() {
        return albumDao.findAll();
    }

    @Override
    public Album findById(UUID id) {
        return albumDao.findById(id);
    }
}
