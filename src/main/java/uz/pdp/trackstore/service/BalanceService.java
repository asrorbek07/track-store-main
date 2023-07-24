package uz.pdp.trackstore.service;

import uz.pdp.trackstore.entity.Balance;

import java.util.List;
import java.util.UUID;

public interface BalanceService {
    boolean insert(Balance balance);

    boolean update(Balance balance);

    List<Balance> findAll();

    Balance findByUserId(UUID userId);

    Balance findById(UUID id);
}
