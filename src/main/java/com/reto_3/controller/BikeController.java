package com.reto_3.controller;


import com.reto_3.entity.Bike;
import com.reto_3.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Bike")
public class BikeController {
    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getBikes(){
        return bikeService.getAll();
    }

    @PostMapping("/save")
    public Bike postBike(@RequestBody Bike bike){
        return bikeService.save(bike);
    }
    @PutMapping
    public Bike putBike(@RequestBody Bike bike){
        return bikeService.update(bike);
    }

    @DeleteMapping
    public void deleteBike(@RequestBody Bike bike){
        bikeService.delete(bike.getId());
    }

}
