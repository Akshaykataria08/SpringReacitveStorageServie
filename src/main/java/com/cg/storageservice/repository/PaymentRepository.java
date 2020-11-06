package com.cg.storageservice.repository;

import java.util.concurrent.CompletableFuture;

import com.cg.storageservice.domain.PaymentMessage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentRepository {

	public Mono<Void> save(PaymentMessage payment);

	public Mono<PaymentMessage> getPaymentById(String msgId);

	public Mono<PaymentMessage> updatePayment(PaymentMessage payment);

	public CompletableFuture<PaymentMessage> deletePaymentById(String msgId);

	public Flux<PaymentMessage> getAllPayment();
}
