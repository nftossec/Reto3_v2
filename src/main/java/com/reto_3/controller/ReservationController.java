package com.reto_3.controller;


import com.reto_3.entity.Reservation;
import com.reto_3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    public Reservation postReservation(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
}
