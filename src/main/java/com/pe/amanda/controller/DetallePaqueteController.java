package com.pe.amanda.controller;

import com.pe.amanda.model.Destinatario;
import com.pe.amanda.model.DetallePaquete;
import com.pe.amanda.service.DetallePaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/detallepaquete")
public class DetallePaqueteController {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> ExceptionHandler(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error al realizar la operación. \n" + "Más información: " + e.getMessage());
    }

    @Autowired
    private DetallePaqueteService service;

    @GetMapping("/listar/{paquete_id_paquete}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<DetallePaquete> listarDetallePaquete(@PathVariable("paquete_id_paquete") Integer paquete_id_paquete) {
        return service.listarDetallePaquete(paquete_id_paquete);
    }


}
