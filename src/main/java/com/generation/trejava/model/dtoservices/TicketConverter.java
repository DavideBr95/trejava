package com.generation.trejava.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.Ticket.TicketDtoR;
import com.generation.trejava.model.dto.Ticket.TicketDtoWWithLine;
import com.generation.trejava.model.dto.Ticket.TicketDtoWplus;
import com.generation.trejava.model.entities.Ticket;
import com.generation.trejava.model.repositories.LineRepository;
import com.generation.trejava.model.repositories.PassengerRepository;
@Service
public class TicketConverter 
{
    @Autowired
    PassengerRepository pRepo;
    @Autowired
    LineRepository lRepo;

    public Ticket dtoRtoTicket(TicketDtoR dto)
    {
        return Ticket
                .builder()
                .owner(pRepo.findById(dto.getPassenger_id()).get())
                .trip(lRepo.findById(dto.getLine_id()).get())
                .level(dto.getLevel())
                .base_price(dto.getBase_price())
                .build();
    }

    public TicketDtoWplus ticketToDtoWplus(Ticket e)
    {
        return TicketDtoWplus
                .builder()
                .id(e.getId())
                .level(e.getLevel())
                .base_price(e.getBase_price())
                .passAnagr(e.getOwner().getName()+" "+e.getOwner().getSurname())
                .effectivePrice(CalcEffectivePrice(e))
                .build();
    }

    public TicketDtoWWithLine ticketToDtoWWithLine(Ticket e)
    {
        return TicketDtoWWithLine
                .builder()
                .id(e.getId())
                .level(e.getLevel())
                .effectivePrice(CalcEffectivePrice(e))
                .line_id(e.getTrip().getId())
                .departure_station(e.getTrip().getDeparture_station())
                .destination_station(e.getTrip().getDestination_station())
                .departure_time(e.getTrip().getDeparture_time())
                .build();
    }

    private double CalcEffectivePrice(Ticket t)
    {
        double res=t.getBase_price();

        if(t.getOwner().getAge()<14)
            res=res*0.8;

        if(t.getOwner().getAge()>65)
            res=res*0.6;

        return res;
    }

}