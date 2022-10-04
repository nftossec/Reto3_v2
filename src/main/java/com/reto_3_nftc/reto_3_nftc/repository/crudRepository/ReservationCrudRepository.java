package com.reto_3_nftc.reto_3_nftc.repository.crudRepository;

import com.reto_3_nftc.reto_3_nftc.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
