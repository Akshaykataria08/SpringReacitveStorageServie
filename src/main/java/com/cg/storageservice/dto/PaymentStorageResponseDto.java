package com.cg.storageservice.dto;

import com.cg.storageservice.exception.ErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStorageResponseDto {

	private String paymentId;
    @NonNull
    private Boolean response;
    private ErrorResponse error;
    @NonNull
    private String actorPath;
}
