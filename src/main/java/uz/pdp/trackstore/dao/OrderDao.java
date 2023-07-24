package uz.pdp.trackstore.dao;

import uz.pdp.trackstore.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderDao {
    boolean insert(Order order);

    List<Order> findAll();

    List<Order> findByUserId(UUID userId);

    Order findById(UUID id);
}
