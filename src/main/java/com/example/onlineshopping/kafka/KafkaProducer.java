package com.example.onlineshopping.kafka;


import com.example.onlineshopping.constant.AppConstant;
import com.example.onlineshopping.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    public String sendMessage(Order message) {

        try {
            kafkaTemplate.send(AppConstant.TOPIC_NAME, message);
        } catch (Exception e) {
            log.error("Error while sending message!");
            e.printStackTrace();
        }
        return "json message sent successfully";
    }

}
