package com.pe.amanda.controller;

import com.pe.amanda.model.Remitente;
import com.pe.amanda.service.RemitenteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/remitente")
@Tag(name = "Remitente")
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
        try {
            service.registrarRemitente(remitente);
            return "Creado correctamente";
        } catch (Exception e) {
            return "Error al registrar remitente. \n" + "Más información: " + e;
        }

    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String actualizarRemitente(@RequestBody Remitente remitente) {
        try {
            service.actualizarRemitente(remitente);
            return "Actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar remitente. \n" + "Más información: " + e;
        }
    }

    @DeleteMapping("/eliminar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String eliminarRemitente(@RequestBody Remitente remitente) {
        try {
            service.eliminarRemitente(remitente);
            return "Eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar remitente. \n" + "Más información: " + e;
        }
    }

}
