package uz.pdp.trackstore.service.impl;

import uz.pdp.trackstore.dao.BalanceDao;
import uz.pdp.trackstore.dao.impl.BalanceDaoImpl;
import uz.pdp.trackstore.entity.Balance;
import uz.pdp.trackstore.service.BalanceService;

import java.util.List;
import java.util.UUID;

public class BalanceServiceImpl implements BalanceService {
    private static final BalanceServiceImpl INSTANCE = new BalanceServiceImpl();

    private BalanceServiceImpl() {
    }

    public static BalanceServiceImpl getInstance() {
        return INSTANCE;
    }
    private final BalanceDao balanceDao = BalanceDaoImpl.getInstance();

    @Override
    public boolean insert(Balance balance) {
        return balanceDao.insert(balance);
    }

    @Override
    public boolean update(Balance balance) {
        return balanceDao.update(balance);
    }

    @Override
    public List<Balance> findAll() {
        return balanceDao.findAll();
    }

    @Override
    public Balance findByUserId(UUID userId) {
        return balanceDao.findByUserId(userId);
    }

    @Override
    public Balance findById(UUID id) {
        return balanceDao.findById(id);
    }
}
