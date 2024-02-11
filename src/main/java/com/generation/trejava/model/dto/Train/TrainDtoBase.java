package com.generation.trejava.model.dto.Train;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TrainDtoBase {

    private Integer id;
    private String serial_number, type;
    private Double average_speed;
    private int capacity;

}
