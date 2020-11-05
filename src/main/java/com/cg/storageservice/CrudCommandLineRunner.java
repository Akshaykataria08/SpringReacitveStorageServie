package com.cg.storageservice;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.storageservice.domain.Payment;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;

@Component
public class CrudCommandLineRunner {

	@Autowired
	private DynamoDbAsyncClient asyncClient;
   
	@Autowired
	private DynamoDbEnhancedAsyncClient enhancedAsyncClient;


	@PostConstruct
	public void run() {

		CompletableFuture<ListTablesResponse> listTablesResponseCompletableFuture = asyncClient.listTables();
        CompletableFuture<List<String>> listCompletableFuture = listTablesResponseCompletableFuture.thenApply(ListTablesResponse::tableNames);
        listCompletableFuture.thenAccept(tables -> {
            if (null != tables && !tables.contains(Payment.class.getSimpleName())) {
            	System.out.println(tables);
                DynamoDbAsyncTable<Payment> payment = enhancedAsyncClient.table(Payment.class.getSimpleName(), TableSchema.fromBean(Payment.class));
                ProvisionedThroughput provisionedThroughput = ProvisionedThroughput.builder()
                        .readCapacityUnits(50L)
                        .writeCapacityUnits(50L)
                        .build();
                payment.createTable(r -> r.provisionedThroughput(provisionedThroughput)).join();
                System.out.println("Tables Created");
            }
        });
	}
}
