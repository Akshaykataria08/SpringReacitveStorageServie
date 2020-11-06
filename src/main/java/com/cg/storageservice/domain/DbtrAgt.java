package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class DbtrAgt {
	private FinInstnId FinInstnId;
	@DynamoDbAttribute("FinInstnId")
	public FinInstnId getFinInstnId() {
		return FinInstnId;
	}

	public void setFinInstnId(FinInstnId finInstnId) {
		this.FinInstnId = finInstnId;
	}
	
}
