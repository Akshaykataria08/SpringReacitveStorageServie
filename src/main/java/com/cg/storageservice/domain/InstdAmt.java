package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class InstdAmt {
	private String Ccy;
	private String text;
	@DynamoDbAttribute("Ccy")
	public String getCcy() {
		return Ccy;
	}

	public void setCcy(String ccy) {
		this.Ccy = ccy;
	}
	@DynamoDbAttribute("text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
