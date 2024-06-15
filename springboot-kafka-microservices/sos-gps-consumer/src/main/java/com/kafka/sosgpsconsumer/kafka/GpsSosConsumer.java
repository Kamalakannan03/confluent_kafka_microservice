package com.kafka.sosgpsconsumer.kafka;

import com.kafka.domainservice.dto.CarEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GpsSosConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(GpsSosConsumer.class);
    @KafkaListener(topics="${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}", autoStartup = "true")
    public void consume(CarEvent carEvent){
        LOGGER.info(String.format("cosumer event recorded %s",carEvent.toString()));
    }

}
