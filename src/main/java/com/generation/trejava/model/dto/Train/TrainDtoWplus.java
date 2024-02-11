package com.generation.trejava.model.dto.Train;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TrainDtoWplus extends TrainDtoBase {

    private int routesTravelled;
    private int timeTravelled;
    private int kmTravelled;
    private int percentageCapacity;
}
