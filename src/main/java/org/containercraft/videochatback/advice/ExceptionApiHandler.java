package org.containercraft.videochatback.advice;

import lombok.extern.slf4j.Slf4j;
import org.containercraft.videochatback.exception.ExistResourceException;
import org.containercraft.videochatback.exception.MessageError;
import org.containercraft.videochatback.exception.NotResourceException;
import org.containercraft.videochatback.exception.NotValidateParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionApiHandler {
    @ExceptionHandler(NotResourceException.class)
    public ResponseEntity<MessageError> notResource(NotResourceException exception){
        log.error(exception.getMessage(),exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(MessageError.of(exception.getMessage()));
    }

    @ExceptionHandler(ExistResourceException.class)
    public ResponseEntity<MessageError> notResource(ExistResourceException exception){
        log.error(exception.getMessage(),exception);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(MessageError.of(exception.getMessage()));
    }

    @ExceptionHandler(NotValidateParamException.class)
    public ResponseEntity<MessageError> notResource(NotValidateParamException exception){
        log.error(exception.getMessage(),exception);
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(MessageError.of(exception.getMessage()));
    }
}
