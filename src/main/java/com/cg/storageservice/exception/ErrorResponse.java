package com.cg.storageservice.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {

	@NonNull
	private String msg;
	@NonNull
	private Integer status;
	@NonNull
	private String errorCode;
}
