package com.example.restservice.models;

import javax.persistence.*;

@Entity
@Table(name = "room_type")
public class Room {
    //  Hibernate relies on an auto-incremented database column to generate the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "description")
    private String description;

    public Room() {
    }

    public Room(String roomType, String description) {
        this.roomType = roomType;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
