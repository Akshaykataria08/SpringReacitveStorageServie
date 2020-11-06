package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class PmtId {
	private String InstrId;
	private String EndToEndId;
	@DynamoDbAttribute("InstrId")
	public String getInstrId() {
		return InstrId;
	}

	public void setInstrId(String instrId) {
		this.InstrId = instrId;
	}
	@DynamoDbAttribute("EndToEndId")
	public String getEndToEndId() {
		return EndToEndId;
	}

	public void setEndToEndId(String endToEndId) {
		this.EndToEndId = endToEndId;
	}

}
