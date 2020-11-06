package com.cg.storageservice.domain;

import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@ToString
@DynamoDbBean
public class PostalAddress {
	private String StrtNm;
	private int BldgNb;
	private String PstCd;
	private String TwnNm;
	private String Ctry;
	@DynamoDbAttribute("StrtNm")
	public String getStrtNm() {
		return StrtNm;
	}

	public void setStrtNm(String strtNm) {
		this.StrtNm = strtNm;
	}
	@DynamoDbAttribute("BldgNb")
	public int getBldgNb() {
		return BldgNb;
	}

	public void setBldgNb(int bldgNb) {
		this.BldgNb = bldgNb;
	}
	@DynamoDbAttribute("PstCd")
	public String getPstCd() {
		return PstCd;
	}

	public void setPstCd(String pstCd) {
		this.PstCd = pstCd;
	}
	@DynamoDbAttribute("TwnNm")
	public String getTwnNm() {
		return TwnNm;
	}

	public void setTwnNm(String twnNm) {
		this.TwnNm = twnNm;
	}
	@DynamoDbAttribute("Ctry")
	public String getCtry() {
		return Ctry;
	}

	public void setCtry(String ctry) {
		this.Ctry = ctry;
	}

}
