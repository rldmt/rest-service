package com.example.restservice.controllers;

import com.example.restservice.models.Hotel;
import com.example.restservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/*")
@RestController
public class HotelController{

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") long id) {
        Optional<Hotel> hotelData = hotelRepository.findById(id);

        if (hotelData.isPresent()) {
            return new ResponseEntity<>(hotelData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        try {
            Hotel _hotel = hotelRepository
                    .save(new Hotel(hotel.getHotel_name(), hotel.getStars(), hotel.getAddress()));
            return new ResponseEntity<>(_hotel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/hotel/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") long id, @RequestBody Hotel hotel) {
        Optional<Hotel> tutorialData = hotelRepository.findById(id);

        if (tutorialData.isPresent()) {
            Hotel _hotel = tutorialData.get();
            _hotel.setHotel_name(hotel.getHotel_name());
            _hotel.setStars(hotel.getStars());
            _hotel.setAddress(hotel.getAddress());
            return new ResponseEntity<>(hotelRepository.save(_hotel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<HttpStatus> deleteHotels(@PathVariable("id") long id) {
        try {
            hotelRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
