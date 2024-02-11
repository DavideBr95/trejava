package com.generation.trejava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.trejava.model.dto.Ticket.TicketDtoR;
import com.generation.trejava.model.dtoservices.TicketConverter;
import com.generation.trejava.model.repositories.TicketRepository;

@RestController
public class TicketController {
    @Autowired
    TicketRepository tRepo;
    @Autowired
    TicketConverter conv;

    @PostMapping("/tickets")
    public void insertTicket(@RequestBody TicketDtoR dto) {
        tRepo.save(conv.dtoRtoTicket(dto));
    }

}
