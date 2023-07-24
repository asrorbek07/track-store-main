package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.PlaylistDao;
import uz.pdp.trackstore.dao.impl.PlaylistDaoImpl;
import uz.pdp.trackstore.entity.Playlist;
import uz.pdp.trackstore.service.PlaylistService;

import java.util.List;
import java.util.UUID;

public class PlaylistServiceImpl implements PlaylistService {
    private static final PlaylistServiceImpl INSTANCE = new PlaylistServiceImpl();

    private PlaylistServiceImpl() {
    }

    public static PlaylistServiceImpl getInstance() {
        return INSTANCE;
    }
    private final PlaylistDao playlistDao = PlaylistDaoImpl.getInstance();

    @Override
    public boolean insert(Playlist playlist) {
        return playlistDao.insert(playlist);
    }

    @Override
    public List<Playlist> findAll() {
        return playlistDao.findAll();
    }

    @Override
    public Playlist findById(UUID id) {
        return playlistDao.findById(id);
    }
}
