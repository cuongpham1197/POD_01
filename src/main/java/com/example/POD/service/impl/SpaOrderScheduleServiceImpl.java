package com.example.POD.service.impl;

import com.example.POD.entity.SpaOrderSchedule;
import com.example.POD.repository.SpaOrderScheduleRepository;
import com.example.POD.service.SpaOrderScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpaOrderScheduleServiceImpl implements SpaOrderScheduleService {
    @Autowired
    private SpaOrderScheduleRepository spaOrderScheduleRepository;

    @Override
    public Optional<SpaOrderSchedule> findByScheduleId(long schedule_id) {
        return spaOrderScheduleRepository.findByScheduleId(schedule_id);
    }

    @Override
    public Iterable<SpaOrderSchedule> findAll() {
        return spaOrderScheduleRepository.findAll();
    }

    @Override
    public SpaOrderSchedule save(SpaOrderSchedule spaOrderSchedule) {
        return spaOrderScheduleRepository.save(spaOrderSchedule);
    }

    @Override
    public void delete(long scheduleId) {
        spaOrderScheduleRepository.deleteByScheduleId(scheduleId);
    }
}
