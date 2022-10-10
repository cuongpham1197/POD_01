package com.example.POD.repository;

import com.example.POD.entity.SpaOrderSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaOrderScheduleRepository extends CrudRepository<SpaOrderSchedule, Long> {
    Optional<SpaOrderSchedule> findByScheduleId(long scheduleId);
    void deleteByScheduleId(long scheduleId);
}
