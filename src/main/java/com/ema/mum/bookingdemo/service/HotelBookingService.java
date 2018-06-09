package com.ema.mum.bookingdemo.service;

import com.ema.mum.bookingdemo.model.HotelBooking;

import java.util.List;

public interface HotelBookingService {
    List<HotelBooking> findByPricePerNightLessThan(double price);
    List<HotelBooking> findAll();
    HotelBooking findOne(Long id);
    HotelBooking save(HotelBooking hotelBooking);
    void deleteById(Long id);
}
