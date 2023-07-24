package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.DiscountDao;
import uz.pdp.trackstore.dao.impl.DiscountDaoImpl;
import uz.pdp.trackstore.entity.Discount;
import uz.pdp.trackstore.service.DiscountService;

import java.util.List;
import java.util.UUID;

public class DiscountServiceImpl implements DiscountService {
    private static final DiscountServiceImpl INSTANCE = new DiscountServiceImpl();

    private DiscountServiceImpl() {
    }

    public static DiscountServiceImpl getInstance() {
        return INSTANCE;
    }
    private final DiscountDao discountDao = DiscountDaoImpl.getInstance();

    @Override
    public boolean insert(Discount discount) {
        return discountDao.insert(discount);
    }

    @Override
    public List<Discount> findAll() {
        return discountDao.findAll();
    }

    @Override
    public Discount findByUserId(UUID userId) {
        return discountDao.findByUserId(userId);
    }

    @Override
    public Discount findById(UUID id) {
        return discountDao.findById(id);
    }
}
