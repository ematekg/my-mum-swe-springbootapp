package com.ema.mum.bookingdemo.service;

import com.ema.mum.bookingdemo.model.HotelBooking;
import com.ema.mum.bookingdemo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelBookingServiceImpl implements HotelBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<HotelBooking> findByPricePerNightLessThan(double price) {
              return bookingRepository.findByPricePerNightLessThan(price);
    }

    @Override
    public List<HotelBooking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public HotelBooking findOne(Long id) {
        return bookingRepository.getOne(id);
    }

    @Override
    public HotelBooking save(HotelBooking hotelBooking) {
       return  bookingRepository.save(hotelBooking);

       // return bookingRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);

    }
}
