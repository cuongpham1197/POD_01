package com.example.POD.controller;

import com.example.POD.entity.ChainEmploymentProfile;
import com.example.POD.service.impl.ChainEmploymentProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api3")
public class ChainEmploymentProfileController {
    @Autowired
    private ChainEmploymentProfileServiceImpl chainEmploymentProfileService;

    @GetMapping("/profile/all")
    public ResponseEntity<Iterable<ChainEmploymentProfile>> getAll() {
        return new ResponseEntity<>(chainEmploymentProfileService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<ChainEmploymentProfile> getProfileById(@RequestParam long id) {
        Optional<ChainEmploymentProfile> profileOptional = chainEmploymentProfileService.findById(id);
        return profileOptional.map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/profile/post")
    public ResponseEntity<ChainEmploymentProfile> createProfile(@RequestBody ChainEmploymentProfile chainEmploymentProfile){
        return new ResponseEntity<>(chainEmploymentProfileService.save(chainEmploymentProfile), HttpStatus.OK);
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<ChainEmploymentProfile> updateProfile(@PathVariable long id, @RequestBody ChainEmploymentProfile chainEmploymentProfile) {
        Optional<ChainEmploymentProfile> profileOptional = chainEmploymentProfileService.findById(id);
        return profileOptional.map(profile1 -> {
            chainEmploymentProfile.setId(profile1.getId());
            return new ResponseEntity<>(chainEmploymentProfileService.save(chainEmploymentProfile), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<ChainEmploymentProfile> deleteProfile(@PathVariable long id){
        Optional<ChainEmploymentProfile> profileOptional=chainEmploymentProfileService.findById(id);
        return profileOptional.map(profile -> {
            chainEmploymentProfileService.delete(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
