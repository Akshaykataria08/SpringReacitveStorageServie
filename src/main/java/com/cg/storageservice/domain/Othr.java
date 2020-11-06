package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Othr {
	private String Id;
	@DynamoDbAttribute("Id")
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

}
