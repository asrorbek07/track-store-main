package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.TrackPlaylistDao;
import uz.pdp.trackstore.dao.impl.TrackPlaylistDaoImpl;
import uz.pdp.trackstore.entity.TrackPlaylist;
import uz.pdp.trackstore.service.TrackPlaylistService;

import java.util.List;
import java.util.UUID;

public class TrackPlaylistServiceImpl implements TrackPlaylistService {
    private static final TrackPlaylistServiceImpl INSTANCE = new TrackPlaylistServiceImpl();

    private TrackPlaylistServiceImpl() {
    }

    public static TrackPlaylistServiceImpl getInstance() {
        return INSTANCE;
    }
    private final TrackPlaylistDao trackPlaylistDao = TrackPlaylistDaoImpl.getInstance();

    @Override
    public boolean insert(TrackPlaylist trackPlaylist) {
        return trackPlaylistDao.insert(trackPlaylist);
    }

    @Override
    public List<TrackPlaylist> findAll() {
        return trackPlaylistDao.findAll();
    }

    @Override
    public TrackPlaylist findById(UUID id) {
        return trackPlaylistDao.findById(id);
    }
}
