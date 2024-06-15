package com.kafka.domainservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String carId;
    private String carName;
    private String carColor;
    private String gpsParam;
}
