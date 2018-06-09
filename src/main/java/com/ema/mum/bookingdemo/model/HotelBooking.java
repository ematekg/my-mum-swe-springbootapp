package com.ema.mum.bookingdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "hotel_booking")
public class HotelBooking {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    public HotelBooking(){}
    public HotelBooking( String hotelName, double pricePerNight, int nbOfNights){

        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setNbOfNights(int nbOfNights) {
        this.nbOfNights = nbOfNights;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getTotalPrice(){
        return pricePerNight*nbOfNights;
    }
}
