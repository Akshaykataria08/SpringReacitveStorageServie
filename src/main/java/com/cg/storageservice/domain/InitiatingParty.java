package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class InitiatingParty {
	private String Nm;
	private PostalAddress PstlAdr;
	@DynamoDbAttribute("Nm")
	public String getNm() {
		return Nm;
	}

	public void setNm(String nm) {
		this.Nm = nm;
	}
	@DynamoDbAttribute("PstlAdr")
	public PostalAddress getPstlAdr() {
		return PstlAdr;
	}

	public void setPstlAdr(PostalAddress pstlAdr) {
		this.PstlAdr = pstlAdr;
	}

}
