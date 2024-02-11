package com.generation.trejava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.repositories.LineRepository;

@RestController
public class LineController {
    @Autowired
    LineRepository lRepo;

    @GetMapping("/allLines")
    public List<Line> getAllLines() {
        return lRepo.findAll();

    }
}
