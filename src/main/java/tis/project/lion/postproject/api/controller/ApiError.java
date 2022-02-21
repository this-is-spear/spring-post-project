package tis.project.lion.postproject.api.controller;

import org.springframework.http.HttpStatus;

public class ApiError {
	private final String message;

	private final int status;

	ApiError(Throwable throwable, HttpStatus status) {
		this(throwable.getMessage(), status);
	}

	ApiError(String message, HttpStatus status) {
		this.message = message;
		this.status = status.value();
	}
}
