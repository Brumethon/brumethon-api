package com.brumethon.app.expostion.error;

import com.brumethon.kernel.exception.SimpleServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    private final static int HTTP_ERROR = 400;
    private final static int HTTP_ERROR_NOT_FOUND = 404;
    private final static int HTTP_ERROR_CONFLICT = 409;

    @ExceptionHandler(value = {SimpleServiceException.class})
    public ResponseEntity<ErrorResponseDTO> manageSimpleServiceException(final SimpleServiceException simpleServiceException) {
        ErrorResponseDTO error = new ErrorResponseDTO(simpleServiceException.getMessage());
        return ResponseEntity.status(HTTP_ERROR).body(error);
    }
}
