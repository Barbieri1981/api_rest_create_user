package com.api.user.exception;

import com.api.user.dto.response.ErrorRsDTO;
import com.api.user.util.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRsDTO> handleException(final Exception e, final WebRequest request) {
        return new ResponseEntity<>(createError(e, ErrorType.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorRsDTO> handleInvalidEmailException(final UserException e, final WebRequest request) {
        return new ResponseEntity<>(createError(e, e.getError()), HttpStatus.BAD_REQUEST);
    }

    private ErrorRsDTO createError(final Exception e, final ErrorType errorType) {
        LOGGER.error("Error:{} ", errorType);
        return new ErrorRsDTO(errorType.getCode(), e.getMessage(), errorType.getDescription());
    }


}
