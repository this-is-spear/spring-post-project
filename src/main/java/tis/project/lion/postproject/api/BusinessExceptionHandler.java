package tis.project.lion.postproject.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.exception.DeleteException;
import tis.project.lion.postproject.exception.NoBoardException;
import tis.project.lion.postproject.exception.NoDataException;
import tis.project.lion.postproject.exception.NoPostException;

@RestControllerAdvice
public class BusinessExceptionHandler {

	@ExceptionHandler(value = {
			NoDataException.class,
			NoPostException.class,
			NoBoardException.class
	})
	public ApiResult handlerNoDataException(NoDataException e) {
		return ApiResult.ERROR(e, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DeleteException.class)
	public ApiResult handlerDeleteException(DeleteException e) {
		return ApiResult.ERROR(e, HttpStatus.BAD_REQUEST);
	}

}
