package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    boolean insert(Order order);

    List<Order> findAll();

    List<Order> findByUserId(UUID userId);

    Order findById(UUID id);
}
