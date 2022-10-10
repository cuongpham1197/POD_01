package com.example.POD.repository;

import com.example.POD.entity.ChainCustomer;
import com.example.POD.entity.SpaOrderSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChainCustomerRepository extends CrudRepository<ChainCustomer, Long> {
    Optional<ChainCustomer> findByCustomerId(long customerId);
    void deleteByCustomerId(long customerId);
}
