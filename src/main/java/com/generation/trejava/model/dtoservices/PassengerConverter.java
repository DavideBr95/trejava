package com.generation.trejava.model.dtoservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.Passenger.PassengerDtoBase;
import com.generation.trejava.model.dto.Passenger.PassengerDtoR;
import com.generation.trejava.model.dto.Passenger.PassengerDtoWplus;
import com.generation.trejava.model.entities.Passenger;
import com.generation.trejava.model.entities.Ticket;

@Service
public class PassengerConverter 
{
    @Autowired
    TicketConverter tConv;

    public Passenger PassengerToDtoR (PassengerDtoR e)
    {
        return Passenger
               .builder()
               .id(e.getId())
               .name(e.getName())
               .surname(e.getSurname())
               .age(e.getAge())
               .build(); 
    } 

    public PassengerDtoBase PassengerToDtoBase (Passenger e)
    {
        return PassengerDtoBase
               .builder()
               .id(e.getId())
               .name(e.getName())
               .surname(e.getSurname())
               .age(e.getAge())
               .build(); 
    } 

    public PassengerDtoWplus PassengerToDtoWplus (Passenger e)
    {
        return PassengerDtoWplus
               .builder()
               .id(e.getId())
               .name(e.getName())
               .surname(e.getSurname())
               .age(e.getAge())
               .totTicket(e.getTicketBought().size())
               .totExp(calcTotExp(e))
               .ticketBought(e.getTicketBought().stream().map(t-> tConv.ticketToDtoWWithLine(t)).toList())
               .build(); 
    }

    private double calcTotExp(Passenger e)
    {

        if(e.getTicketBought()==null)
            return 0;
        
            double res = 0;

        for(Ticket t:e.getTicketBought())
            res+=t.getBase_price();
        
        if(e.getAge()<14)
            return res*0.8;

        if(e.getAge()>65)
            return res*0.6;
        
        return res;
 
    }
}
