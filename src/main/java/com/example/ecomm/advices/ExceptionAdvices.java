package com.example.ecomm.advices;

import com.example.ecomm.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionAdvices {
    @ExceptionHandler(Exception.class)
    public ErrorResponseDto handleException(Exception e) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setMessage(e.getMessage());
        dto.setStatus("ERROR");
        return dto;
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRuntimeException(RuntimeException e) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setMessage(e.getMessage());
        dto.setStatus("ERROR");
        return dto;
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ErrorResponseDto handleNotFoundException(HttpClientErrorException.NotFound e) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setMessage(e.getMessage());
        dto.setStatus("ERROR");
        return dto;
    }
}
