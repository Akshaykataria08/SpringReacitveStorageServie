package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Cdtr {
	private String Nm;
	private PstlAdr PstlAdr;
	@DynamoDbAttribute("Nm")
	public String getNm() {
		return Nm;
	}

	public void setNm(String nm) {
		this.Nm = nm;
	}
	@DynamoDbAttribute("PstlAdr")
	public PstlAdr getPstlAdr() {
		return PstlAdr;
	}

	public void setPstlAdr(PstlAdr pstlAdr) {
		this.PstlAdr = pstlAdr;
	}

}
