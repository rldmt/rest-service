package com.example.restservice.controllers;

import com.example.restservice.models.Hotel;
import com.example.restservice.models.Room;
import com.example.restservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/*")
@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") long id)
    {
        Optional<Room> roomData = roomRepository.findById(id);

        return roomData.map(room -> new ResponseEntity<>(room, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/rooms")
    public  ResponseEntity<Room> createRoom(@RequestBody Room room) {
        try {
            Room _room = roomRepository
                    .save(new Room(room.getRoomType(), room.getDescription()));
            return new ResponseEntity<>(_room, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/room/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
        Optional<Room> roomData = roomRepository.findById(id);

        if(roomData.isPresent()) {
            Room _room = roomData.get();
            _room.setRoomType(room.getRoomType());
            _room.setDescription(room.getDescription());
            return new ResponseEntity<>(roomRepository.save(_room), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") long id) {
        try {
            roomRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
