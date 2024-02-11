package com.generation.trejava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.trejava.model.dto.Line.LineDtoWplus;
import com.generation.trejava.model.dtoservices.LineConverter;
import com.generation.trejava.model.repositories.LineRepository;

@RestController
public class LineController {
    @Autowired
    LineRepository lRepo;
    @Autowired
    LineConverter lConv;

    @GetMapping("/allLines")
    public List<LineDtoWplus> getAllLines() {
        return lRepo.findAll().
                        stream().
                        map(e -> lConv.LineToDtoWplus(e)).
                        toList();
    }
}
