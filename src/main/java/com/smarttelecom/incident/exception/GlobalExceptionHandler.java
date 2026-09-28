package com.smarttelecom.incident.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IncidentNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleNotFound(IncidentNotFoundException e){
        Map<String,String> r=new HashMap<>(); r.put("error",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException e){
        Map<String,String> r=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(x->r.put(x.getField(),x.getDefaultMessage()));
        return ResponseEntity.badRequest().body(r);
    }
}