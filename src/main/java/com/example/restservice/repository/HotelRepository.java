package com.example.restservice.repository;

import com.example.restservice.models.Hotel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Override
    List<Hotel> findAll(Sort sort);

//    List<Hotel> findHotelsBy(String name);
}
