package nl.mfarr.backendcontrolleruitwerkingen.controllers;

import nl.mfarr.backendcontrolleruitwerkingen.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exceptions")

public class ExceptionController {
    @ExceptionHandler
    public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}

