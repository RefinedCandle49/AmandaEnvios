package com.pe.amanda.controller;

import com.pe.amanda.model.DetallePaquete;
import com.pe.amanda.model.Envio;
import com.pe.amanda.model.Remitente;
import com.pe.amanda.service.EnvioService;
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
@RequestMapping("/envio")
@Tag(name = "Envío")
public class EnvioController {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> ExceptionHandler(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error al realizar la operación. \n" + "Más información: " + e.getMessage());
    }

    @Autowired
    private EnvioService service;

    @GetMapping("/listar/{id_guia}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Envio> listarEnvio(@PathVariable("id_guia") Integer id_guia) {
        return service.listarEnvio(id_guia);
    }

    @DeleteMapping("/eliminar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String eliminarEnvio(@RequestBody Envio envio) {
        try {
            service.eliminarEnvio(envio);
            return "Eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar envio. \n" + "Más información: " + e;
        }
    }

}
