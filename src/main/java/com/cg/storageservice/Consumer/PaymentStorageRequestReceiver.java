package com.cg.storageservice.Consumer;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.storageservice.domain.PaymentMessage;
import com.cg.storageservice.dto.PaymentStorageResponseDto;
import com.cg.storageservice.dto.PaymentWithActorRef;
import com.cg.storageservice.exception.ErrorResponse;
import com.cg.storageservice.producer.PaymentStorageAckProducer;
import com.cg.storageservice.service.StorageService;

import lombok.extern.log4j.Log4j2;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

@Log4j2
@Component
public class PaymentStorageRequestReceiver {

	@Autowired
	private ReceiverOptions<String, PaymentWithActorRef> paymentReceiverOptions;

	@Autowired
	private StorageService storageService;

	@Autowired
	private PaymentStorageAckProducer paymentStorageAckProducer;

	private static String PAYMENT_STORAGE_RECEIVER_TOPIC = "payment-storage-topic";
	private KafkaReceiver<String, PaymentWithActorRef> paymentStorageReceiver;

	@PostConstruct
	public void initializePaymentStorageReceiver() {
		this.paymentStorageReceiver = this.createKafkaReceiver(PAYMENT_STORAGE_RECEIVER_TOPIC, paymentReceiverOptions);
		this.paymentStorageReceiver.receive().doOnNext(msg -> {

			PaymentMessage payment = msg.value().getPaymentMessage();
			storageService.isDuplicatePayment(payment).doOnNext(duplicatePayment -> {
				if (duplicatePayment) {
					paymentStorageAckProducer.generateMsg(msg.key(),
							createPaymentStorageAck(null, msg.value().getActorPath(), false,
									new ErrorResponse("Duplicate Payment", 1, "DUPLICATE_PAYMENT")));
				} else {
					storageService.storePayment(payment)
							.doOnNext(paymentId -> paymentStorageAckProducer.generateMsg(msg.key(),
									createPaymentStorageAck(paymentId, msg.value().getActorPath(), true, null)))
							.doOnError(e -> paymentStorageAckProducer.generateMsg(msg.key(),
									createPaymentStorageAck(null, msg.value().getActorPath(), false, new ErrorResponse(
											"Couldn't able to store Payment", 2, "INTERNAL_SERVER_ERROR"))))
							.subscribe();
				}
			}).doOnError(r -> paymentStorageAckProducer.generateMsg(msg.key(),
					createPaymentStorageAck(null, msg.value().getActorPath(), false,
							new ErrorResponse("Couldn't able to store Payment", 2, "INTERNAL_SERVER_ERROR"))))
					.subscribe();

			msg.receiverOffset().acknowledge();
		}).subscribe();
	}

	private PaymentStorageResponseDto createPaymentStorageAck(String paymentId, String actorPath, Boolean response,
			ErrorResponse error) {
		PaymentStorageResponseDto dto = new PaymentStorageResponseDto();
		dto.setActorPath(actorPath);
		dto.setPaymentId(paymentId);
		dto.setResponse(response);
		if (!response) {
			if (error == null) {
				throw new IllegalArgumentException("You must provide error object if response is false");
			}
			dto.setError(error);
		}
		return dto;
	}

	private KafkaReceiver<String, PaymentWithActorRef> createKafkaReceiver(String topic,
			ReceiverOptions<String, PaymentWithActorRef> paymentReceiverOptions) {

		ReceiverOptions<String, PaymentWithActorRef> options = paymentReceiverOptions
				.subscription(Collections.singleton(topic))
				.addAssignListener(partitions -> log.debug("onPartitionsAssigned {}", partitions))
				.addRevokeListener(partitions -> log.debug("onPartitionsRevoked {}", partitions));
		return KafkaReceiver.create(options);
	}
}
