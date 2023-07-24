package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.Discount;

import java.util.List;
import java.util.UUID;

public interface DiscountService {
    boolean insert(Discount discount);

    List<Discount> findAll();

    Discount findByUserId(UUID userId);

    Discount findById(UUID id);
}
