package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Purp {
	private String Cd;
	@DynamoDbAttribute("Cd")
	public String getCd() {
		return Cd;
	}

	public void setCd(String cd) {
		this.Cd = cd;
	}

}
