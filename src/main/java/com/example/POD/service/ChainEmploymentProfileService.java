package com.example.POD.service;

import com.example.POD.entity.ChainCustomer;
import com.example.POD.entity.ChainEmploymentProfile;

import java.util.Optional;

public interface ChainEmploymentProfileService {
    Optional<ChainEmploymentProfile> findById(long id);
    Iterable<ChainEmploymentProfile> findAll();
    ChainEmploymentProfile save(ChainEmploymentProfile chainEmploymentProfile);
    void delete(long id);
}
