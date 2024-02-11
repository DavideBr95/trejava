package com.generation.trejava.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.Train.TrainDtoR;
import com.generation.trejava.model.dto.Train.TrainDtoWplus;
import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.entities.Train;

@Service
public class TrainConverter {
    @Autowired
    LineConverter lineC;

    public Train dtoRToTrain(TrainDtoR dto) {
        return Train
                .builder()
                .serial_number(dto.getSerial_number())
                .average_speed(dto.getAverage_speed())
                .capacity(dto.getCapacity())
                .build();

    }

    // private int id;
    // private int routesTravelled;
    // private int timeTravelled;
    // private int percentageCapacity;
    public TrainDtoWplus TrainDtoWplus(Train e) {
        return TrainDtoWplus
                .builder()
                .id(e.getId())
                .serial_number(e.getSerial_number())
                .average_speed(e.getAverage_speed())
                .capacity(e.getCapacity())
                .routesTravelled(e.getRailwayLine().size())
                .kmTravelled(kmTravelled(e))
                .timeTravelled(timeTravelled(e))
                .percentageCapacity(averageCapiency(e))
                .build();

    }

    private int kmTravelled(Train e) {
        if (e.getRailwayLine() == null)
            return 0;

        int res = 0;
        for (Line l : e.getRailwayLine()) {
            res += l.getLenght();
        }

        return res;
    }

    private int timeTravelled(Train e) {
        if (e.getRailwayLine() == null)
            return 0;

        int res = 0;
        for(Line l: e.getRailwayLine())
            res+=lineC.calcDurMin(l);

        return res;
    }

    private int averageCapiency(Train t) {
    int totTicketsForThatTrain = 0;
    for (Line l : t.getRailwayLine())
    totTicketsForThatTrain += l.getTicketSold().size();

    int averageTickPerLine = totTicketsForThatTrain / t.getRailwayLine().size();

    return averageTickPerLine / t.getCapacity() * 100;
    }
}
