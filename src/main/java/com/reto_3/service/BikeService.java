package com.reto_3.service;

import com.reto_3.entity.Bike;
import com.reto_3.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
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
        } else {
            Optional<Bike> e=bikeRepository.getBike(bike.getId());
            if(e.isEmpty()){
                return bikeRepository.save(bike);
            } else {
                return bike;
            }
        }

    }

    public Bike update(Bike bike){
        if(bike.getId()!=null){
            Optional<Bike> q = bikeRepository.getBike(bike.getId());
            if(q.isPresent()){
                Field[] fields = q.get().getClass().getDeclaredFields();
                for (Field field: fields) {
                    field.setAccessible(true);
                    try {
                        Object value=field.get(bike);
                        if(value!=null){
                            field.set(q.get(),value);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
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
            bikeRepository.deleteBike(bike.get().getId());
            flag=true;
        }
        return flag;
    }
}
