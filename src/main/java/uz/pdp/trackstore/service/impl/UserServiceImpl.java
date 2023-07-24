package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.UserDao;
import uz.pdp.trackstore.dao.impl.UserDaoImpl;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private static final UserServiceImpl INSTANCE = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }

    private final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public boolean authenticate(String login, String password) {
        return userDao.authenticate(login, password);
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean activateOrBlock(UUID userId, boolean isActivating) {
        return userDao.activateOrBlock(userId, isActivating);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userDao.findById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public List<User> findAllWithoutUser(UUID userId) {
        return userDao.findAllWithoutUser(userId);
    }

}
