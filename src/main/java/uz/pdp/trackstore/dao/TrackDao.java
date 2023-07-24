package uz.pdp.trackstore.dao;

import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;

import java.util.List;
import java.util.UUID;

public interface TrackDao {
    boolean insert(Track track);

    List<Track> findAll();

    List<Track> findAllNotContainsOrder(User current_user);

    Track findById(UUID id);

}
