package tis.project.lion.postproject.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tis.project.lion.postproject.api.controller.ApiResult;

@RestControllerAdvice
public class ServerExceptionHandler {
	@ExceptionHandler
	public ApiResult handlerServerException() {
		return ApiResult.ERROR(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
