package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.OrderDao;
import uz.pdp.trackstore.dao.TrackDao;
import uz.pdp.trackstore.dao.impl.OrderDaoImpl;
import uz.pdp.trackstore.dao.impl.TrackDaoImpl;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.TrackService;

import java.util.List;
import java.util.UUID;

public class TrackServiceImpl implements TrackService {
    private static final TrackServiceImpl INSTANCE = new TrackServiceImpl();

    private TrackServiceImpl() {
    }

    public static TrackServiceImpl getInstance() {
        return INSTANCE;
    }

    private final TrackDao trackDao = TrackDaoImpl.getInstance();

    @Override
    public boolean insert(Track track) {
        return trackDao.insert(track);
    }

    @Override
    public List<Track> findAllNotContainsOrder(User current_user) {
        return trackDao.findAllNotContainsOrder(current_user);
    }

    @Override
    public List<Track> findAll() {
        return trackDao.findAll();
    }

    @Override
    public Track findById(UUID id) {
        return trackDao.findById(id);
    }
}
