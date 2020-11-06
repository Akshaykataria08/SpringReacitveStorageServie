package com.cg.storageservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@NoArgsConstructor
@DynamoDbBean
public class PaymentMessage {

    private String transactionId;
    private String paymentId;
    private CustomerCreditTransferInitiation CstmrCdtTrfInitn;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("TransactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @DynamoDbAttribute("CstmrCdtTrfInitn")
    public CustomerCreditTransferInitiation getCstmrCdtTrfInitn() {
        return CstmrCdtTrfInitn;
    }

    public void setCstmrCdtTrfInitn(CustomerCreditTransferInitiation cstmrCdtTrfInitn) {
        this.CstmrCdtTrfInitn = cstmrCdtTrfInitn;
    }
}
