package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class RfrdDocInf {
	private String Nb;
	private String RltdDt;
	
	@DynamoDbAttribute("Nb")
	public String getNb() {
		return Nb;
	}

	public void setNb(String nb) {
		this.Nb = nb;
	}
	
	@DynamoDbAttribute("RltdDt")
	public String getRltdDt() {
		return RltdDt;
	}

	public void setRltdDt(String rltdDt) {
		this.RltdDt = rltdDt;
	}

}
