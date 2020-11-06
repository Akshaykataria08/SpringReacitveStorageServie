package com.cg.storageservice.repository;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Repository;

import com.cg.storageservice.domain.PaymentMessage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

	private DynamoDbAsyncTable<PaymentMessage> paymentDynamoDbAsyncTable;

	public PaymentRepositoryImpl(DynamoDbEnhancedAsyncClient asyncClient) {
		this.paymentDynamoDbAsyncTable = asyncClient.table(PaymentMessage.class.getSimpleName(),
				TableSchema.fromBean(PaymentMessage.class));
	}

	// CREATE
	@Override
	public Mono<Void> save(PaymentMessage payment) {
		return Mono.fromFuture(paymentDynamoDbAsyncTable.putItem(payment));
	}

	// READ
	@Override
	public Mono<PaymentMessage> getPaymentById(String msgId) {
		return Mono.fromFuture(paymentDynamoDbAsyncTable.getItem(getKeyBuild(msgId)));
	}

	// UPDATE
	@Override
	public Mono<PaymentMessage> updatePayment(PaymentMessage payment) {
		return Mono.fromFuture(paymentDynamoDbAsyncTable.updateItem(payment));
	}

	// DELETE
	@Override
	public CompletableFuture<PaymentMessage> deletePaymentById(String msgId) {
		return paymentDynamoDbAsyncTable.deleteItem(getKeyBuild(msgId));
	}

	// GET_ALL_ITEM
	@Override
	public Flux<PaymentMessage> getAllPayment() {
		return Flux.from(paymentDynamoDbAsyncTable.scan().items());
	}
	
//	public Mono<Payment> getPayment(String msgId, Integer amount) {
//		paymentDynamoDbAsyncTable.query(r -> r.queryConditional(queryConditional))
//	}
	
	private Key getKeyBuild(String msgId) {
		return Key.builder().partitionValue(msgId).build();
	}
}
