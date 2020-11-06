package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class FinInstnId {
	private String BIC;
	@DynamoDbAttribute("BIC")
	public String getBIC() {
		return BIC;
	}

	public void setBIC(String bIC) {
		this.BIC = bIC;
	}
	
}
