package tis.project.lion.postproject.api.controller;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class ApiResult<T> {

	private final boolean success;

	private final T response;

	private final ApiError error;

	public ApiResult(boolean success, T response, ApiError error) {
		this.success = success;
		this.response = response;
		this.error = error;
	}

	public static <T> ApiResult<T> OK(T response) {
		return new ApiResult<>(true, response, null);
	}

	public static ApiResult<?> ERROR(Throwable throwable, HttpStatus status) {
		return new ApiResult<>(false, null, new ApiError(throwable, status));
	}

	public static ApiResult<?> SERVER_ERROR(Throwable throwable, HttpStatus status) {
		return new ApiResult<>(false, null, new ApiError("server error", status));
	}

	public boolean isSuccess() {
		return success;
	}

	public T getResponse() {
		return response;
	}

	public ApiError getError() {
		return error;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ApiResult<?> apiResult = (ApiResult<?>) o;
		return isSuccess() == apiResult.isSuccess() && Objects.equals(getResponse(), apiResult.getResponse()) && Objects.equals(getError(), apiResult.getError());
	}

	@Override
	public int hashCode() {
		return Objects.hash(isSuccess(), getResponse(), getError());
	}
}
