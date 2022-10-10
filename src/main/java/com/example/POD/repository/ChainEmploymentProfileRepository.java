package com.example.POD.repository;

import com.example.POD.entity.ChainCustomer;
import com.example.POD.entity.ChainEmploymentProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChainEmploymentProfileRepository extends CrudRepository<ChainEmploymentProfile, Long> {
    Optional<ChainEmploymentProfile> findById(long id);
    void deleteById(long id);
}
