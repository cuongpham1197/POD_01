package com.example.POD.service;

import com.example.POD.entity.SpaOrderSchedule;

import java.util.Optional;


public interface SpaOrderScheduleService {
    Optional<SpaOrderSchedule> findByScheduleId(long scheduleId);
    Iterable<SpaOrderSchedule> findAll();
    SpaOrderSchedule save(SpaOrderSchedule spaOrderSchedule);
    void delete(long scheduleId);
}
