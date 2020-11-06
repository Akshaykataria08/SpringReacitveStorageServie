package com.cg.storageservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.storageservice.domain.PaymentMessage;
import com.cg.storageservice.repository.PaymentRepository;

import reactor.core.publisher.Mono;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Mono<Boolean> isDuplicatePayment(PaymentMessage payment) {
		Mono<PaymentMessage> paymentMono =  paymentRepository.getPaymentById(payment.getTransactionId()).defaultIfEmpty(new PaymentMessage());
		paymentMono.subscribe();
		return paymentMono.map(paymentObj -> paymentObj.getTransactionId() != null);
	}

	@Override
	public Mono<String> storePayment(PaymentMessage payment) {
		String paymentId = this.generateAndAddPaymentId(payment);
		return paymentRepository.save(payment).thenReturn(paymentId);
	}

	private String generateAndAddPaymentId(PaymentMessage payment) {
		String paymentId = UUID.randomUUID().toString();
		payment.setPaymentId(paymentId);
		return paymentId;
	}

}
