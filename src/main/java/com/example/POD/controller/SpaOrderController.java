package com.example.POD.controller;

import com.example.POD.entity.SpaOrderSchedule;
import com.example.POD.service.impl.SpaOrderScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SpaOrderController {
    @Autowired
    private SpaOrderScheduleServiceImpl spaOrderScheduleService;

    @GetMapping("/order/all")
    public ResponseEntity<Iterable<SpaOrderSchedule>> getAll() {
        return new ResponseEntity<>(spaOrderScheduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/order/{scheduleId}")
    public ResponseEntity<SpaOrderSchedule> getOrderByScheduleId(@RequestParam long scheduleId) {
        Optional<SpaOrderSchedule> spaOrderOptional = spaOrderScheduleService.findByScheduleId(scheduleId);
        return spaOrderOptional.map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/order/post")
    public ResponseEntity<SpaOrderSchedule> createOrder(@RequestBody SpaOrderSchedule order){
        return new ResponseEntity<>(spaOrderScheduleService.save(order), HttpStatus.OK);
    }

    @PutMapping("/order/{scheduleId}")
    public ResponseEntity<SpaOrderSchedule> updateOrder(@PathVariable long scheduleId, @RequestBody SpaOrderSchedule order) {
        Optional<SpaOrderSchedule> orderOptional = spaOrderScheduleService.findByScheduleId(scheduleId);
        return orderOptional.map(order1 -> {
            order.setScheduleId(order1.getScheduleId());
            return new ResponseEntity<>(spaOrderScheduleService.save(order), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<SpaOrderSchedule> deleteOrder(@PathVariable long scheduleId){
        Optional<SpaOrderSchedule> spaOrderOptional=spaOrderScheduleService.findByScheduleId(scheduleId);
        return spaOrderOptional.map(order -> {
            spaOrderScheduleService.delete(scheduleId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
