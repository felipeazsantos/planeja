package dev.felipeazsantos.planeja.infra.handlers;

import dev.felipeazsantos.planeja.common.exceptions.NotFoundException;
import dev.felipeazsantos.planeja.common.exceptions.ValidationException;
import dev.felipeazsantos.planeja.common.validation.CampoInvalido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        var status = HttpStatus.UNPROCESSABLE_CONTENT;
        var body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", e.getMessage(),
                "camposInvalidados", e.getCamposInvalidos()
        );

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var camposInvalidos = e.getFieldErrors()
                .stream()
                .map(fe -> new CampoInvalido(fe.getField(), fe.getDefaultMessage()))
                .toList();

        var status = HttpStatus.UNPROCESSABLE_CONTENT;
        var body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", e.getMessage(),
                "camposInvalidados", camposInvalidos
        );

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        var body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.NOT_FOUND.value(),
                "error", e.getMessage(),
                "message", e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
