package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class DbtrAcct {
	private Id Id;
	@DynamoDbAttribute("Id")
	public Id getId() {
		return Id;
	}

	public void setId(Id id) {
		this.Id = id;
	}

}
