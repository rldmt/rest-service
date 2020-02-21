package com.example.restservice.controllers;

import com.example.restservice.models.Hotel;
import com.example.restservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController{

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
