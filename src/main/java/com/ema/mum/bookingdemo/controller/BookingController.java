package com.ema.mum.bookingdemo.controller;

import com.ema.mum.bookingdemo.model.HotelBooking;
import com.ema.mum.bookingdemo.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    private HotelBookingService bookingService;

    public BookingController() {

    }

    @RequestMapping("/")
    public String home(Model model) {
        return "index";

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAll(Model model) {
        List<HotelBooking> bookings = bookingService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bookings", bookings);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id, Model model) {
        //model.addAttribute("booking", bookingService.findOne(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booking", bookingService.findOne(id));
        modelAndView.setViewName("edit");

        return modelAndView;
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return bookingService.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView editBooking(@Valid @ModelAttribute("booking") HotelBooking booking, BindingResult bindingResult) {
        bookingService.save(booking);
         return new ModelAndView("redirect:/bookings/list");
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("booking") HotelBooking booking) {
        bookingService.save(booking);
        return new ModelAndView("redirect:/bookings/list");
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable Long id) {
        bookingService.deleteById(id);
        return new ModelAndView("redirect:/bookings/list");
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addnew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booking", new HotelBooking());
        modelAndView.setViewName("addnew");
        return modelAndView;


    }
}
