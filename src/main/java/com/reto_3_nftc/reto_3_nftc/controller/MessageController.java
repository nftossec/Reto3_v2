package com.reto_3_nftc.reto_3_nftc.controller;


import com.reto_3_nftc.reto_3_nftc.entity.Message;
import com.reto_3_nftc.reto_3_nftc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message message){
        return messageService.save(message);

    }
}
