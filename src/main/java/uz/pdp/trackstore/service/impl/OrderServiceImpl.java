package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.OrderDao;
import uz.pdp.trackstore.dao.impl.OrderDaoImpl;
import uz.pdp.trackstore.entity.Order;
import uz.pdp.trackstore.service.OrderService;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();

    private OrderServiceImpl() {
    }

    public static OrderServiceImpl getInstance() {
        return INSTANCE;
    }

    OrderDao orderDao = OrderDaoImpl.getInstance();

    @Override
    public boolean insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findByUserId(UUID userId) {
        return orderDao.findByUserId(userId);
    }

    @Override
    public Order findById(UUID id) {
        return orderDao.findById(id);
    }
}
