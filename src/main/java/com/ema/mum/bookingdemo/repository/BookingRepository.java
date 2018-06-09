package com.ema.mum.bookingdemo.repository;

import com.ema.mum.bookingdemo.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking,Long> {

    List<HotelBooking> findByPricePerNightLessThan(double price);
}
