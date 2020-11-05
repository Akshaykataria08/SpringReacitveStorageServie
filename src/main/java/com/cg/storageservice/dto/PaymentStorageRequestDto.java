package com.cg.storageservice.dto;

import com.cg.storageservice.domain.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStorageRequestDto {

	private Payment payment;
    private String actorPath;
}
