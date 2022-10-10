package com.example.POD.service.impl;

import com.example.POD.entity.ChainCustomer;
import com.example.POD.repository.ChainCustomerRepository;
import com.example.POD.service.ChainCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChainCustomerServiceImpl implements ChainCustomerService {
    @Autowired
    private ChainCustomerRepository chainCustomerRepository;

    @Override
    public Iterable<ChainCustomer> findAll(){ return chainCustomerRepository.findAll();}

    @Override
    public Optional<ChainCustomer> findByCustomerId(long customerId){
        return chainCustomerRepository.findByCustomerId(customerId);
    }

    @Override
    public ChainCustomer save(ChainCustomer chainCustomer) {
        return chainCustomerRepository.save(chainCustomer);
    }

    @Override
    public void delete(long customerId){
        chainCustomerRepository.deleteByCustomerId(customerId);
    }
}
