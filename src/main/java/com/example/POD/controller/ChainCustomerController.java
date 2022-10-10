package com.example.POD.controller;

import com.example.POD.entity.ChainCustomer;
import com.example.POD.service.impl.ChainCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api2")
public class ChainCustomerController {
    @Autowired
    private ChainCustomerServiceImpl chainCustomerService;

    @GetMapping("/customer/all")
    public ResponseEntity<Iterable<ChainCustomer>> getAll() {
        return new ResponseEntity<>(chainCustomerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ChainCustomer> getCustomerByCustomerId(@RequestParam long customerId) {
        Optional<ChainCustomer> customerOptional = chainCustomerService.findByCustomerId(customerId);
        return customerOptional.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/customer/post")
    public ResponseEntity<ChainCustomer> createCustomer(@RequestBody ChainCustomer chainCustomer){
        return new ResponseEntity<>(chainCustomerService.save(chainCustomer), HttpStatus.OK);
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<ChainCustomer> updateCustomer(@PathVariable long customerId, @RequestBody ChainCustomer chainCustomer) {
        Optional<ChainCustomer> customerOptional = chainCustomerService.findByCustomerId(customerId);
        return customerOptional.map(chainCustomer1 -> {
            chainCustomer.setCustomerId(chainCustomer1.getCustomerId());
            return new ResponseEntity<>(chainCustomerService.save(chainCustomer), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<ChainCustomer> deleteCustomer(@PathVariable long customerId){
        Optional<ChainCustomer> customerOptional=chainCustomerService.findByCustomerId(customerId);
        return customerOptional.map(customer -> {
            chainCustomerService.delete(customerId);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
