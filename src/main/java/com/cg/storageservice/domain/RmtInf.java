package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class RmtInf {
	private Strd Strd;
	@DynamoDbAttribute("Strd")
	public Strd getStrd() {
		return Strd;
	}

	public void setStrd(Strd strd) {
		this.Strd = strd;
	}

}
