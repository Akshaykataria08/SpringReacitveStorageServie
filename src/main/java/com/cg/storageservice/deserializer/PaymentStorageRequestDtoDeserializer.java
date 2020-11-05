package com.cg.storageservice.deserializer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.cg.storageservice.dto.PaymentStorageRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentStorageRequestDtoDeserializer implements Deserializer<PaymentStorageRequestDto>{

    @Override
    public PaymentStorageRequestDto deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        PaymentStorageRequestDto paymentStorageRequestDto = null;
        try {
        	paymentStorageRequestDto = mapper.readValue(bytes, PaymentStorageRequestDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paymentStorageRequestDto;
    }
}
