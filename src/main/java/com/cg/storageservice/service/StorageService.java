package com.cg.storageservice.service;

import com.cg.storageservice.domain.PaymentMessage;

import reactor.core.publisher.Mono;

public interface StorageService {

	public Mono<Boolean> isDuplicatePayment(PaymentMessage payment);

	public Mono<Void> storePayment(PaymentMessage payment);

}
