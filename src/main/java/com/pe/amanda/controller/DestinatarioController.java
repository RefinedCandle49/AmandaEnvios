package com.pe.amanda.controller;

import com.pe.amanda.model.Destinatario;
import com.pe.amanda.model.Remitente;
import com.pe.amanda.service.DestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/destinatario")
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

    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String registrarDestinatario(@RequestBody Destinatario destinatario) {
        try {
            service.registrarDestinatario(destinatario);
            return "Creado correctamente";
        } catch (Exception e) {
            return "Error al registrar destinatario. \n" + "Más información: " + e;
        }

    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String actualizarDestinatario(@RequestBody Destinatario destinatario) {
        try {
            service.actualizarDestinatario(destinatario);
            return "Actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar destinatario. \n" + "Más información: " + e;
        }
    }

    @DeleteMapping("/eliminar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String eliminarDestinatario(@RequestBody Destinatario destinatario) {
        try {
            service.eliminarDestinatario(destinatario);
            return "Eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar destinatario. \n" + "Más información: " + e;
        }
    }
}
