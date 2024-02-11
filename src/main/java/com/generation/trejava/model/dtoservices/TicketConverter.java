package com.generation.trejava.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.Ticket.TicketDtoR;
import com.generation.trejava.model.dto.Ticket.TicketDtoWWithLine;
import com.generation.trejava.model.dto.Ticket.TicketDtoWplus;
import com.generation.trejava.model.entities.Ticket;
@Service
public class TicketConverter 
{

    public Ticket dtoRtoTicket(TicketDtoR dto)
    {
        return Ticket
                .builder()
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
                .effectivePrice(CaclEffectivePrice(e))
                .build();
    }

    public TicketDtoWWithLine ticketToDtoWWithLine(Ticket e)
    {
        return TicketDtoWWithLine
                .builder()
                .id(e.getId())
                .level(e.getLevel())
                .base_price(e.getBase_price())
                .line_id(e.getTrip().getId())
                .departure_station(e.getTrip().getDeparture_station())
                .destination_station(e.getTrip().getDestination_station())
                .departure_time(e.getTrip().getDeparture_time())
                .build();
    }

    private double CaclEffectivePrice(Ticket t)
    {
        double res=t.getBase_price();

        if(t.getOwner().getAge()<14)
            res=(res/100)*20;

        if(t.getOwner().getAge()>65)
            res=(res/100)*40;
        
        return res;
    }

}