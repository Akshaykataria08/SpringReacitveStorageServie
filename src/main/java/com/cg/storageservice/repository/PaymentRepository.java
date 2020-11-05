package com.cg.storageservice.repository;

import java.util.concurrent.CompletableFuture;

import com.cg.storageservice.domain.Payment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentRepository {

	public Mono<Void> save(Payment payment);

	public Mono<Payment> getPaymentById(String msgId);

	public Mono<Payment> updatePayment(Payment payment);

	public CompletableFuture<Payment> deletePaymentById(String msgId);

	public Flux<Payment> getAllPayment();
}
