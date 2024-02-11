package com.generation.trejava.model.dto.Ticket;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TicketDtoWWithLine extends TicketDtoWplus
{
       
    //linea
    private Integer line_id;
    private String departure_station,destination_station;
    private LocalDateTime departure_time;
}
