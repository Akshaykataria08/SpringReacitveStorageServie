package com.cg.storageservice.dto;

import com.cg.storageservice.domain.PaymentMessage;

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
	private PaymentMessage paymentMessage;
    @NonNull
	private String actorPath;
}
