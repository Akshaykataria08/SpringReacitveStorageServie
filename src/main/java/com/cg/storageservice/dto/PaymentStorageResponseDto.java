package com.cg.storageservice.dto;

import com.cg.storageservice.domain.Payment;
import com.cg.storageservice.exception.ErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentStorageResponseDto {

	@NonNull
	private Payment payment;
    @NonNull
	private String actorPath;
    @NonNull
    private Boolean response;
    private ErrorResponse error;
}
