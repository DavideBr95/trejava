package com.generation.trejava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.trejava.model.dto.Passenger.PassengerDtoBase;
import com.generation.trejava.model.dto.Passenger.PassengerDtoR;
import com.generation.trejava.model.dto.Passenger.PassengerDtoWplus;
import com.generation.trejava.model.dtoservices.PassengerConverter;
import com.generation.trejava.model.entities.Passenger;
import com.generation.trejava.model.repositories.PassengerRepository;

@RestController
public class PassengerController 
{

    @Autowired
    PassengerRepository repo;
    @Autowired
    PassengerConverter conv;

    @GetMapping("/passengers")
    public List<PassengerDtoBase> getAllPassengers() 
    {
        return repo.findAll()
               .stream()
               .map(e -> conv.PassengerToDtoBase(e))
               .toList();
    }

    @GetMapping("/passengers/{id}/tickets")
    public PassengerDtoWplus getPassengerDtoWplus(@PathVariable Integer id) {
        return conv.PassengerToDtoWplus(repo.findById(id).get());
    }

    @PostMapping("/passengers")
    public Passenger insertPassenger(@RequestBody PassengerDtoR dto) {
        return repo.save(conv.PassengerToDtoR(dto));
    }

    @PutMapping("/passengers/{id}")
    public PassengerDtoBase updatePassenger(@RequestBody PassengerDtoR dto,@PathVariable Integer id) {
        Passenger p = conv.PassengerToDtoR(dto);
        p.setId(id);
        return conv.PassengerToDtoBase(repo.save(p));
    }

    @DeleteMapping("/passengers/{id}")
    public void  deletePassenger(@PathVariable Integer id) {
         repo.deleteById(id);
    }

}
