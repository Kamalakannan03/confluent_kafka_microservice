package com.kafka.cargpsproducer.controller;

import com.kafka.cargpsproducer.kafka.GpsProducer;
import com.kafka.domainservice.dto.Car;
import com.kafka.domainservice.dto.CarEvent;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class CarGpsController {
    private GpsProducer gpsProducer;
    /*

    */

    public CarGpsController(GpsProducer gpsProducer) {
        this.gpsProducer = gpsProducer;
    }
    @PostMapping("/gps")
    public String setGpsAttributes(@RequestBody Car car){
        car.setCarId(UUID.randomUUID().toString());
        CarEvent carEvent = new CarEvent();
        carEvent.setSos("true");
        carEvent.setCar(car);
        gpsProducer.sendMessage(carEvent);
        return "sent car gps attributes successfully!!!";
    }
}
