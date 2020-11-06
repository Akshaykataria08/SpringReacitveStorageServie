package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Strd {
	private RfrdDocInf RfrdDocInf;
	@DynamoDbAttribute("RfrdDocInf")
	public RfrdDocInf getRfrdDocInf() {
		return RfrdDocInf;
	}

	public void setRfrdDocInf(RfrdDocInf rfrdDocInf) {
		this.RfrdDocInf = rfrdDocInf;
	}

}
