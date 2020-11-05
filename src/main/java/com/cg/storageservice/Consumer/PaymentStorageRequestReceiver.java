package com.cg.storageservice.Consumer;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.storageservice.domain.Payment;
import com.cg.storageservice.dto.PaymentStorageRequestDto;
import com.cg.storageservice.dto.PaymentStorageResponseDto;
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
	private ReceiverOptions<String, PaymentStorageRequestDto> paymentReceiverOptions;

	@Autowired
	private StorageService storageService;

	@Autowired
	private PaymentStorageAckProducer paymentStorageAckProducer;

	private static String PAYMENT_STORAGE_RECEIVER_TOPIC = "payment-storage-topic";
	private KafkaReceiver<String, PaymentStorageRequestDto> paymentStorageReceiver;

	@PostConstruct
	public void initializePaymentStorageReceiver() {
		this.paymentStorageReceiver = this.createKafkaReceiver(PAYMENT_STORAGE_RECEIVER_TOPIC, paymentReceiverOptions);
		this.paymentStorageReceiver.receive().doOnNext(msg -> {

			Payment payment = msg.value().getPayment();
			storageService.isDuplicatePayment(payment).doOnNext(duplicatePayment -> {
				if (duplicatePayment) {
					System.out.println("Duplicate Payment");
					paymentStorageAckProducer.generateMsg(msg.key(), createPaymentStorageAck(msg.value(), false,
							new ErrorResponse("Duplicate Payment", 1, "DUPLICATE_PAYMENT")));
				} else {
					storageService.storePayment(payment)
							.doOnSuccess(s -> {
								System.out.println("Hello" + s);
								paymentStorageAckProducer
									.generateMsg(msg.key(), createPaymentStorageAck(msg.value(), true, null));
							}).doOnError(e -> {
								System.out.println("Bye" + e);
								paymentStorageAckProducer.generateMsg(msg.key(),
										createPaymentStorageAck(msg.value(), false, new ErrorResponse(
												"Couldn't able to store Payment", 2, "INTERNAL_SERVER_ERROR")));
							}).subscribe();
				}
			}).doOnError(r -> paymentStorageAckProducer.generateMsg(msg.key(),
					createPaymentStorageAck(msg.value(), false,
							new ErrorResponse("Couldn't able to store Payment", 2, "INTERNAL_SERVER_ERROR"))))
					.subscribe();

			msg.receiverOffset().acknowledge();
		}).subscribe();
	}

	private PaymentStorageResponseDto createPaymentStorageAck(PaymentStorageRequestDto paymentStorageRequestDto,
			Boolean response, ErrorResponse error) {
		PaymentStorageResponseDto dto = new PaymentStorageResponseDto();
		dto.setActorPath(paymentStorageRequestDto.getActorPath());
		dto.setPayment(paymentStorageRequestDto.getPayment());
		dto.setResponse(response);
		if (!response) {
			if (error == null) {
				throw new IllegalArgumentException("You must provide error object if response is false");
			}
			dto.setError(error);
		}
		return dto;
	}

	private KafkaReceiver<String, PaymentStorageRequestDto> createKafkaReceiver(String topic,
			ReceiverOptions<String, PaymentStorageRequestDto> paymentReceiverOptions) {

		ReceiverOptions<String, PaymentStorageRequestDto> options = paymentReceiverOptions
				.subscription(Collections.singleton(topic))
				.addAssignListener(partitions -> log.debug("onPartitionsAssigned {}", partitions))
				.addRevokeListener(partitions -> log.debug("onPartitionsRevoked {}", partitions));
		return KafkaReceiver.create(options);
	}
}
