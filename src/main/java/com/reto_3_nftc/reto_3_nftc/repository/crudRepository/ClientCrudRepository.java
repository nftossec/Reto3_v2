package com.reto_3_nftc.reto_3_nftc.repository.crudRepository;

import com.reto_3_nftc.reto_3_nftc.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
