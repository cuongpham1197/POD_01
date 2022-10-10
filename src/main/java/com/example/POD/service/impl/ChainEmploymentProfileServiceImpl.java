package com.example.POD.service.impl;

import com.example.POD.entity.ChainCustomer;
import com.example.POD.entity.ChainEmploymentProfile;
import com.example.POD.repository.ChainCustomerRepository;
import com.example.POD.repository.ChainEmploymentProfileRepository;
import com.example.POD.service.ChainEmploymentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChainEmploymentProfileServiceImpl implements ChainEmploymentProfileService {
    @Autowired
    private ChainEmploymentProfileRepository chainEmploymentProfileRepository;

    @Override
    public Iterable<ChainEmploymentProfile> findAll(){ return chainEmploymentProfileRepository.findAll();}

    @Override
    public Optional<ChainEmploymentProfile> findById(long id){
        return chainEmploymentProfileRepository.findById(id);
    }

    @Override
    public ChainEmploymentProfile save(ChainEmploymentProfile chainEmploymentProfile) {
        return chainEmploymentProfileRepository.save(chainEmploymentProfile);
    }

    @Override
    public void delete(long id){
        chainEmploymentProfileRepository.deleteById(id);
    }
}
