package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    boolean authenticate(String login, String password);

    boolean insert(User user);

    boolean update(User user);

    boolean activateOrBlock(UUID userId, boolean isActivating);

    List<User> findAll();

    User findById(UUID id);

    User findByUserName(String userName);

    List<User> findAllWithoutUser(UUID userId);

}
