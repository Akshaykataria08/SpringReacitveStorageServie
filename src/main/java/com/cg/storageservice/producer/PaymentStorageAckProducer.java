package com.cg.storageservice.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.storageservice.dto.PaymentStorageResponseDto;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.KafkaSender;

@Log4j2
@Component
public class PaymentStorageAckProducer {

	@Autowired
	private KafkaSender<String, PaymentStorageResponseDto> paymentStorageResponseSender;

	private static final String PAYMENT_STORAGE_ACK_TOPIC = "payment-storage-ack-topic";

	public void generateMsg(String key, PaymentStorageResponseDto dto) {
		paymentStorageResponseSender.createOutbound()
				.send(Flux.just(
						new ProducerRecord<String, PaymentStorageResponseDto>(PAYMENT_STORAGE_ACK_TOPIC, key, dto)))
				.then()
				.doOnError(e -> log.error("Sending failed"))
				.doOnSuccess(s -> log.info("Msg sent to Kafka successfully")).subscribe();
	}
}
