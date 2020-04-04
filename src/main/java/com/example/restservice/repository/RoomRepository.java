package com.example.restservice.repository;

import com.example.restservice.models.Room;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Override
    List<Room> findAll(Sort sort);
}
