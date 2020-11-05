package com.cg.storageservice.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DynamoDbBean
public class Payment {

	private String msgId;
    private String merchantId;
    private double amount;
    private String email;
	
    @DynamoDbPartitionKey
    @DynamoDbAttribute("MsgId")
    public String getMsgId() {
		return msgId;
	}
    
    @DynamoDbAttribute("MerchantId")
	public String getMerchantId() {
		return merchantId;
	}
    
    @DynamoDbAttribute("Amount")
	public double getAmount() {
		return amount;
	}
    
    @DynamoDbAttribute("Email")
	public String getEmail() {
		return email;
	}
}
