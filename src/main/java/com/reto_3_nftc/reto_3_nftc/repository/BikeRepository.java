package com.reto_3_nftc.reto_3_nftc.repository;

import com.reto_3_nftc.reto_3_nftc.entity.Bike;
import com.reto_3_nftc.reto_3_nftc.repository.crudRepository.BikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepository {

    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getAll(){
        return (List<Bike>) bikeCrudRepository.findAll();  //casteo
    }

    public Bike save(Bike bike){
        return bikeCrudRepository.save(bike);
    }

    public Optional<Bike> getBike(int id){
        return bikeCrudRepository.findById(id);
    }

    public void delete(Bike bike){
        bikeCrudRepository.delete(bike);
    }

}
