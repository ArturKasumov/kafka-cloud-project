package com.arturk.service;

import com.arturk.entity.Product;
import com.arturk.entity.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @Autowired
    private ProductRepository productRepository;

    @KafkaListener(id = "productGroupListener1",
            groupId = "productGroup", concurrency = "2",
            topicPartitions = @TopicPartition(topic = "${kafka.topic.name}", partitions = {"0", "1"}))
    public void processRecord(@Payload Product product, @Header(KafkaHeaders.RECEIVED_PARTITION) int partitionId) {
        log.info("Record: {} with key: {} and partitionId: {} was processed", product, product.getCategory().getCategoryName(), partitionId);
        productRepository.save(product);
    }

    @KafkaListener(id = "productGroupListener2",
            groupId = "productGroup", concurrency = "1",
            topicPartitions = @TopicPartition(topic = "${kafka.topic.name}", partitions = {"2"}))
    public void processRecord1(@Payload Product product, @Header(KafkaHeaders.RECEIVED_PARTITION) int partitionId) {
        log.info("Record: {} with key: {} and partitionId: {} was processed", product, product.getCategory().getCategoryName(), partitionId);
        productRepository.save(product);
    }
}
