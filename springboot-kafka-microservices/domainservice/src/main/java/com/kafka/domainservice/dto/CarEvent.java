package com.kafka.domainservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEvent {
    private String message;
    private String sos;
    private Car car;
}
