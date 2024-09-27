package com.arturk.service;

import com.arturk.dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String kafkaTopicName;

    public void createProduct(Product product) {
        log.info("Sending product: {} to kafka topic: {}", product, kafkaTopicName);
        kafkaTemplate.send(kafkaTopicName, product.getCategory().getCategoryName(), product);
    }
}
