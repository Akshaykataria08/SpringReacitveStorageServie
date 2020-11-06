package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.List;
@DynamoDbBean
public class PstlAdr {
	private List<String> AdrLine;
	@DynamoDbAttribute("AdrLine")
	public List<String> getAdrLine() {
		return AdrLine;
	}

	public void setAdrLine(List<String> adrLine) {
		this.AdrLine = adrLine;
	}

}
