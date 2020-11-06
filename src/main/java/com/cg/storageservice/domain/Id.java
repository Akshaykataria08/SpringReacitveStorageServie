package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Id {
	private Othr Othr;
	@DynamoDbAttribute("Othr")
	public Othr getOthr() {
		return Othr;
	}

	public void setOthr(Othr othr) {
		this.Othr = othr;
	}

}
