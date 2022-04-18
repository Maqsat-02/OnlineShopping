package com.example.onlineshopping.kafka;

import com.example.onlineshopping.constant.AppConstant;
import com.example.onlineshopping.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {


    @KafkaListener(groupId = AppConstant.GROUP_ID_JSON, topics = AppConstant.TOPIC_NAME, containerFactory = AppConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void receivedMessage(Order message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        log.info("Json message received using Kafka listener " + jsonString);
    }
}
