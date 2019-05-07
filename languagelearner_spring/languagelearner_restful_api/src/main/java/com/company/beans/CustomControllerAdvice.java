package com.company.beans;

import com.company.dto.ResponseDTO;
import com.company.exceptions.NotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
class CustomControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseDTO notFoundHandler(NotfoundException ex) {
        return ResponseDTO.of(ex.getMessage(), 404);
    }


    @ResponseBody
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseDTO sqlEx(SQLException ex) {
        return ResponseDTO.of(ex.getMessage(), 404);
    }
}