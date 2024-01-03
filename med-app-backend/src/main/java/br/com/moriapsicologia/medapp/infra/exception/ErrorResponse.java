package br.com.moriapsicologia.medapp.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String status;
    private String message;

}
