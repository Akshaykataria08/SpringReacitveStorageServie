package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class CustomerCreditTransferInitiation {
	private GroupHeader GrpHdr;
	private PaymentInformation PmtInf;
	@DynamoDbAttribute("GrpHdr")
	public GroupHeader getGrpHdr() {
		return GrpHdr;
	}

	public void setGrpHdr(GroupHeader grpHdr) {
		this.GrpHdr = grpHdr;
	}
	@DynamoDbAttribute("PmtInf")
	public PaymentInformation getPmtInf() {
		return PmtInf;
	}

	public void setPmtInf(PaymentInformation pmtInf) {
		this.PmtInf = pmtInf;
	}

}
