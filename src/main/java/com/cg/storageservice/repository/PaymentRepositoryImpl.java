package com.cg.storageservice.repository;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Repository;

import com.cg.storageservice.domain.Payment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

	private DynamoDbAsyncTable<Payment> paymentDynamoDbAsyncTable;

	public PaymentRepositoryImpl(DynamoDbEnhancedAsyncClient asyncClient) {
		this.paymentDynamoDbAsyncTable = asyncClient.table(Payment.class.getSimpleName(),
				TableSchema.fromBean(Payment.class));
	}

	// CREATE
	@Override
	public Mono<Void> save(Payment payment) {
		return Mono.fromFuture(paymentDynamoDbAsyncTable.putItem(payment));
	}

	// READ
	@Override
	public Mono<Payment> getPaymentById(String msgId) {
		return Mono.fromFuture(paymentDynamoDbAsyncTable.getItem(getKeyBuild(msgId)));
	}

	// UPDATE
	@Override
	public Mono<Payment> updatePayment(Payment payment) {
		return Mono.fromFuture(paymentDynamoDbAsyncTable.updateItem(payment));
	}

	// DELETE
	@Override
	public CompletableFuture<Payment> deletePaymentById(String msgId) {
		return paymentDynamoDbAsyncTable.deleteItem(getKeyBuild(msgId));
	}

	// GET_ALL_ITEM
	@Override
	public Flux<Payment> getAllPayment() {
		return Flux.from(paymentDynamoDbAsyncTable.scan().items());
	}
	
	private Key getKeyBuild(String msgId) {
		return Key.builder().partitionValue(msgId).build();
	}
}
