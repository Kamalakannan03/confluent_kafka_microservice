package com.kafka.cargpsproducer.kafka;

import com.kafka.domainservice.dto.CarEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class GpsProducer {
    private NewTopic topic;
    private KafkaTemplate<String, CarEvent> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(GpsProducer.class);

    public GpsProducer(NewTopic topic, KafkaTemplate<String, CarEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(CarEvent carEvent){
        LOGGER.info(String.format("car event %s",carEvent.toString()));
        Message<CarEvent> message = MessageBuilder.withPayload(carEvent)
                .setHeader(KafkaHeaders.TOPIC,topic.name())
                .setHeader("__TypeId__", "com.kafka.gps_consumer.dto.CarEvent")
                .build();
        kafkaTemplate.send(message);
    }
}
