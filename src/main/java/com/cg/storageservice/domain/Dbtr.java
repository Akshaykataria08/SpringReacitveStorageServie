package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Dbtr {
	private String Nm;
	private PostalAddress PstlAdr;
	@DynamoDbAttribute("Nm")
	public String getNm() {
		return Nm;
	}

	public void setNm(String nm) {
		Nm = nm;
	}
	@DynamoDbAttribute("PstlAdr")
	public PostalAddress getPstlAdr() {
		return PstlAdr;
	}

	public void setPstlAdr(PostalAddress pstlAdr) {
		PstlAdr = pstlAdr;
	}

}
