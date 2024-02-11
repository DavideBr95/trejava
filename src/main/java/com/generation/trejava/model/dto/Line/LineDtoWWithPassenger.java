package com.generation.trejava.model.dto.Line;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LineDtoWWithPassenger extends LineDtoBase
{
    //id nel DtoBase

    private Integer passenger_id;

}
