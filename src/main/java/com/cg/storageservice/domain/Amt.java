package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Amt {
	private InstdAmt InstdAmt;
	@DynamoDbAttribute("InstdAmt")
	public InstdAmt getInstdAmt() {
		return InstdAmt;
	}

	public void setInstdAmt(InstdAmt instdAmt) {
		InstdAmt = instdAmt;
	}

}
