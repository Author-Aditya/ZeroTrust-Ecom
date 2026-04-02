package com.dailymart.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(
                new ApiError(ex.getMessage(), "User not found"),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiError> handleInvalidCredentials(InvalidCredentialsException ex) {
        return new ResponseEntity<>(
                new ApiError(ex.getMessage(), "Invalid login"),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(AccountLockedException.class)
    public ResponseEntity<ApiError> handleAccountLocked(AccountLockedException ex) {
        return new ResponseEntity<>(
                new ApiError(ex.getMessage(), "Account locked"),
                HttpStatus.LOCKED
        );
    }

    @ExceptionHandler(AccountInactiveException.class)
    public ResponseEntity<ApiError> handleInactive(AccountInactiveException ex) {
        return new ResponseEntity<>(
                new ApiError(ex.getMessage(), "Account inactive"),
                HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiError> handleDuplicate(DuplicateResourceException ex) {
        return new ResponseEntity<>(
                new ApiError(ex.getMessage(), "Duplicate resource"),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex) {
        return new ResponseEntity<>(
                new ApiError("Something went wrong", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}