package com.reto_3.controller;

import com.reto_3.entity.Score;
import com.reto_3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/save")
    public Score postScore(@RequestBody Score data){
        return scoreService.save(data);
    }
}
