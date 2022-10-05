package com.reto_3.controller;


import com.reto_3.entity.UsuaryAdmin;
import com.reto_3.service.UsuaryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class UsuaryAdminController {

    @Autowired
    private UsuaryAdminService usuaryAdminService;

    @GetMapping("/all")
    public List<UsuaryAdmin> getAdmins(){
        return usuaryAdminService.getAll();
    }

    @PostMapping("/save")
    public UsuaryAdmin postAdmin(@RequestBody UsuaryAdmin usuaryAdmin){
        return usuaryAdminService.save(usuaryAdmin);
    }
}
