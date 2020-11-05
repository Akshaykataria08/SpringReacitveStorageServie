package com.cg.storageservice.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

@Configuration
public class DynamoDbConfig {

	@Value("${aws.dynamodb.endpoint}")
	private String dynamoDbEndPointUrl;
	
	@Value("${aws.dynamodb.region}")
	private String region;

	@Bean
	public DynamoDbAsyncClient getDynamoDbAsyncClient() {
		return DynamoDbAsyncClient.builder()
				.region(Region.of(region))
				.endpointOverride(URI.create(dynamoDbEndPointUrl))
				.build();
	}

	@Bean
	public DynamoDbEnhancedAsyncClient getDynamoDbEnhancedAsyncClient() {
		return DynamoDbEnhancedAsyncClient.builder().dynamoDbClient(getDynamoDbAsyncClient()).build();
	}
	
	
}
