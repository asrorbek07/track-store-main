package uz.pdp.trackstore.dao;

import uz.pdp.trackstore.entity.Discount;

import java.util.List;
import java.util.UUID;

public interface DiscountDao {
    boolean insert(Discount discount);

    List<Discount> findAll();

    Discount findByUserId(UUID userId);

    Discount findById(UUID id);
}
