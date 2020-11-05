package com.cg.storageservice.service;

import com.cg.storageservice.domain.Payment;

import reactor.core.publisher.Mono;

public interface StorageService {

	public Mono<Boolean> isDuplicatePayment(Payment payment);

	public Mono<Void> storePayment(Payment payment);

}
