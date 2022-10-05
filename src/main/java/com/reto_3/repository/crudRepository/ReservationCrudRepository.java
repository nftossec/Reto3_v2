package com.reto_3.repository.crudRepository;

import com.reto_3.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
