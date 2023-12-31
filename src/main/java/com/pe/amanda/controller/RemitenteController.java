package com.pe.amanda.controller;

import com.pe.amanda.model.Remitente;
import com.pe.amanda.service.RemitenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/remitente")
public class RemitenteController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> ExceptionHandler(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error al realizar la operación. \n" + "Más información: " + e.getMessage());
    }

    @Autowired
    private RemitenteService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Remitente> listarRemitentes() {
        return service.listarRemitentes();
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String registrarRemitente(@RequestBody Remitente remitente) {
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        try {
            service.registrarRemitente(remitente);
            return "Creado correctamente";
        } catch (Exception e) {
            return "Error al registrar remitente. \n" + "Más información:" + e;
        }

    }


}
