package com.reto_3_nftc.reto_3_nftc.controller;


import com.reto_3_nftc.reto_3_nftc.entity.UsuaryAdmin;
import com.reto_3_nftc.reto_3_nftc.service.UsuaryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class UsuaryAdminController {

    @Autowired
    private UsuaryAdminService usuaryAdminService;

    @GetMapping("/all")
    public List<UsuaryAdmin> getAll(){
        return usuaryAdminService.getAll();
    }

    @PostMapping("/save")
    public UsuaryAdmin save(@RequestBody UsuaryAdmin usuaryAdmin){
        return usuaryAdminService.save(usuaryAdmin);

    }
}
