package com.generation.trejava.model.dtoservices;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.Line.LineDtoR;
import com.generation.trejava.model.dto.Line.LineDtoWplus;
import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.entities.Train;

@Service
public class LineConverter {

    public LineDtoR LineToDtoR (Line l)
    {
        return LineDtoR
               .builder()
               .id(l.getId())
               .departure_station(l.getDeparture_station())
               .destination_station(l.getDestination_station())
               .lenght(l.getLenght())
               .departure_time(l.getDeparture_time())
               .build(); 
    } 

    public LineDtoWplus LineToDtoWplus (Line l)
    {
        return LineDtoWplus
               .builder()
               .id(l.getId())
               .departure_station(l.getDeparture_station())
               .destination_station(l.getDestination_station())
               .lenght(l.getLenght())
               .departure_time(l.getDeparture_time())
               .duration(calcDurMin(l))
               .arrivalTime(calcArrTime(l))
               .build(); 
    }

    protected double calcDurMin (Line l)
    {
        double res=0;
        Train t = l.getLocomotive();
        res=l.getLenght()/t.getAverage_speed();
        if(res>=60)
            return res;
        return res*60;
    }

    private LocalDateTime calcArrTime (Line l)
    {
        return l.getDeparture_time().plusMinutes((long)calcDurMin(l));
    }
}
