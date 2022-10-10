package com.example.POD.service;

import com.example.POD.entity.ChainCustomer;

import java.util.Optional;

public interface ChainCustomerService {
    Optional<ChainCustomer> findByCustomerId(long customerId);
    Iterable<ChainCustomer> findAll();
    ChainCustomer save(ChainCustomer chainCustomer);
    void delete(long customerId);
}
