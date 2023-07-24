package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;

import java.util.List;
import java.util.UUID;

public interface TrackService {
    boolean insert(Track track);

    List<Track> findAllNotContainsOrder(User current_user);

    List<Track> findAll();

    Track findById(UUID id);
}
