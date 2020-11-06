package com.cg.storageservice.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
@DynamoDbBean
public class PaymentInformation {
	private String PmtInfId;
	private String PmtMtd;
	private boolean BtchBookg;
	private String ReqdExctnDt;
	private Dbtr Dbtr;
	private DbtrAcct DbtrAcct;
	private DbtrAgt DbtrAgt;
	private CreditTransferTransactionInformation CdtTrfTxInf;
	@DynamoDbAttribute("PmtInfId")
	public String getPmtInfId() {
		return PmtInfId;
	}

	public void setPmtInfId(String pmtInfId) {
		this.PmtInfId = pmtInfId;
	}
	@DynamoDbAttribute("PmtMtd")
	public String getPmtMtd() {
		return PmtMtd;
	}

	public void setPmtMtd(String pmtMtd) {
		this.PmtMtd = pmtMtd;
	}
	@DynamoDbAttribute("BtchBookg")
	public boolean isBtchBookg() {
		return BtchBookg;
	}

	public void setBtchBookg(boolean btchBookg) {
		this.BtchBookg = btchBookg;
	}
	@DynamoDbAttribute("ReqdExctnDt")
	public String getReqdExctnDt() {
		return ReqdExctnDt;
	}

	public void setReqdExctnDt(String reqdExctnDt) {
		this.ReqdExctnDt = reqdExctnDt;
	}
	@DynamoDbAttribute("Dbtr")
	public Dbtr getDbtr() {
		return Dbtr;
	}

	public void setDbtr(Dbtr dbtr) {
		this.Dbtr = dbtr;
	}
	@DynamoDbAttribute("DbtrAcct")
	public DbtrAcct getDbtrAcct() {
		return DbtrAcct;
	}

	public void setDbtrAcct(DbtrAcct dbtrAcct) {
		this.DbtrAcct = dbtrAcct;
	}
	@DynamoDbAttribute("DbtrAgt")
	public DbtrAgt getDbtrAgt() {
		return DbtrAgt;
	}

	public void setDbtrAgt(DbtrAgt dbtrAgt) {
		this.DbtrAgt = dbtrAgt;
	}
	@DynamoDbAttribute("CdtTrfTxInf")
	public CreditTransferTransactionInformation getCdtTrfTxInf() {
		return CdtTrfTxInf;
	}

	public void setCdtTrfTxInf(CreditTransferTransactionInformation cdtTrfTxInf) {
		this.CdtTrfTxInf = cdtTrfTxInf;
	}

}
