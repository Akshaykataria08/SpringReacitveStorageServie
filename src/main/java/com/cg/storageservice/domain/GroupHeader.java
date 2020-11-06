package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
@DynamoDbBean
public class GroupHeader {
	private String MsgId;
	private String CreDtTm;
	private int NbOfTxs;
	private double CtrlSum;
	private InitiatingParty InitgPty;
	@DynamoDbAttribute("MsgId")
	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		this.MsgId = msgId;
	}
	@DynamoDbAttribute("CreDtTm")
	public String getCreDtTm() {
		return CreDtTm;
	}

	public void setCreDtTm(String creDtTm) {
		this.CreDtTm = creDtTm;
	}
	@DynamoDbAttribute("NbOfTxs")
	public int getNbOfTxs() {
		return NbOfTxs;
	}

	public void setNbOfTxs(int nbOfTxs) {
		this.NbOfTxs = nbOfTxs;
	}
	@DynamoDbAttribute("CtrlSum")
	public double getCtrlSum() {
		return CtrlSum;
	}

	public void setCtrlSum(double ctrlSum) {
		this.CtrlSum = ctrlSum;
	}
	@DynamoDbAttribute("InitgPty")
	public InitiatingParty getInitgPty() {
		return InitgPty;
	}

	public void setInitgPty(InitiatingParty initgPty) {
		this.InitgPty = initgPty;
	}

}
