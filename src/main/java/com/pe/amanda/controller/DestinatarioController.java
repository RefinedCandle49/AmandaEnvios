package com.pe.amanda.controller;

import com.pe.amanda.model.Destinatario;
import com.pe.amanda.model.Remitente;
import com.pe.amanda.service.DestinatarioService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Hidden
@RequestMapping("/destinatario")
@Tag(name = "Destinatario")
public class DestinatarioController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> ExceptionHandler(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error al realizar la operación. \n" + "Más información: " + e.getMessage());
    }

     @Autowired
    private DestinatarioService service;
    
    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Destinatario> listarDestinatarios() {
        return service.listarDestinatarios();
    }
}
