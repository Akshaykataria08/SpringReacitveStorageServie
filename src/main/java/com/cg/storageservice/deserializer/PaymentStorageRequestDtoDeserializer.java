package com.cg.storageservice.deserializer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.cg.storageservice.dto.PaymentWithActorRef;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentStorageRequestDtoDeserializer implements Deserializer<PaymentWithActorRef>{

    @Override
    public PaymentWithActorRef deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        PaymentWithActorRef paymentStorageRequestDto = null;
        try {
        	paymentStorageRequestDto = mapper.readValue(bytes, PaymentWithActorRef.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paymentStorageRequestDto;
    }
}
