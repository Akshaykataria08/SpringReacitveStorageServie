package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class CreditTransferTransactionInformation {
	private PmtId PmtId;
	private Amt Amt;
	private String ChrgBr;
	private CdtrAgt CdtrAgt;
	private Cdtr Cdtr;
	private CdtrAcct CdtrAcct;
	private Purp Purp;
	private RmtInf RmtInf;
	@DynamoDbAttribute("PmtId")
	public PmtId getPmtId() {
		return PmtId;
	}

	public void setPmtId(PmtId pmtId) {
		this.PmtId = pmtId;
	}
	@DynamoDbAttribute("Amt")
	public Amt getAmt() {
		return Amt;
	}

	public void setAmt(Amt amt) {
		this.Amt = amt;
	}
	@DynamoDbAttribute("ChrgBr")
	public String getChrgBr() {
		return ChrgBr;
	}

	public void setChrgBr(String chrgBr) {
		this.ChrgBr = chrgBr;
	}
	@DynamoDbAttribute("CdtrAgt")
	public CdtrAgt getCdtrAgt() {
		return CdtrAgt;
	}

	public void setCdtrAgt(CdtrAgt cdtrAgt) {
		this.CdtrAgt = cdtrAgt;
	}
	@DynamoDbAttribute("Cdtr")
	public Cdtr getCdtr() {
		return Cdtr;
	}

	public void setCdtr(Cdtr cdtr) {
		this.Cdtr = cdtr;
	}
	@DynamoDbAttribute("CdtrAcct")
	public CdtrAcct getCdtrAcct() {
		return CdtrAcct;
	}

	public void setCdtrAcct(CdtrAcct cdtrAcct) {
		this.CdtrAcct = cdtrAcct;
	}
	@DynamoDbAttribute("Purp")
	public Purp getPurp() {
		return Purp;
	}

	public void setPurp(Purp purp) {
		this.Purp = purp;
	}
	@DynamoDbAttribute("RmtInf")
	public RmtInf getRmtInf() {
		return RmtInf;
	}

	public void setRmtInf(RmtInf rmtInf) {
		this.RmtInf = rmtInf;
	}

}
