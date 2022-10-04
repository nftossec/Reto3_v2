package com.reto_3_nftc.reto_3_nftc.service;

import com.reto_3_nftc.reto_3_nftc.entity.Bike;
import com.reto_3_nftc.reto_3_nftc.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }

    public Optional<Bike> getBike(int id){
        return bikeRepository.getBike(id);
    }

    public Bike save(Bike bike){
        if(bike.getId()==null){
            return bikeRepository.save(bike);
        }else {

            Optional<Bike> e=bikeRepository.getBike(bike.getId());
            if(e.isPresent()){
                return bike;
            }else{
                return bikeRepository.save(bike);
            }
        }

    }

    public Bike update(Bike bike){
        if(bike.getId()!=null){
            Optional<Bike> q = bikeRepository.getBike(bike.getId());
            if(q.isPresent()){
                if(bike.getYear()!=null){
                    q.get().setYear(bike.getYear());
                }
                if(bike.getBrand()!=null){
                    q.get().setBrand(bike.getBrand());
                }
                if(bike.getCategory()!=null){
                    q.get().setCategory(bike.getCategory());
                }

                bikeRepository.save(q.get());
                return q.get();

            }else {
                return bike;
            }

        }else {
            return bike;
        }
    }


    public boolean delete(int id){
        Boolean flag=false;
        Optional<Bike> bike=bikeRepository.getBike(id);
        if(bike.isPresent()){
            bikeRepository.delete(bike.get());
            flag=true;
        }

        return flag;
    }
}
