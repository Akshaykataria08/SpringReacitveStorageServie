package com.cg.storageservice.dto;

import com.cg.storageservice.domain.Payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class PaymentWithActorRef {

	@NonNull
	private Payment paymentMessage;
    @NonNull
	private String actorPath;
}
