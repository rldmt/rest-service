package com.example.restservice.models;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hotel_id;

    @Column(name = "hotel_name")
    private String hotel_name;

    @Column(name = "stars")
    private short stars;

    @Column(name = "address")
    private String address;

    public Hotel() {
    }

    public Hotel(String hotel_name, short stars, String address) {
        this.hotel_name = hotel_name;
        this.stars = stars;
        this.address = address;
    }

    public long getHotel_id() {
        return hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public short getStars() {
        return stars;
    }

    public void setStars(short stars) {
        this.stars = stars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", stars=" + stars +
                ", address='" + address + '\'' +
                '}';
    }

}
