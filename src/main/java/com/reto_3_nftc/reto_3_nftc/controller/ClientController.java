package com.reto_3_nftc.reto_3_nftc.controller;


import com.reto_3_nftc.reto_3_nftc.entity.Client;
import com.reto_3_nftc.reto_3_nftc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);

    }
}
