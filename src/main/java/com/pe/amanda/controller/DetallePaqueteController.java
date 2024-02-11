package com.pe.amanda.controller;

import com.pe.amanda.model.Destinatario; //Esto porque?
import com.pe.amanda.model.DetallePaquete;
import com.pe.amanda.service.DetallePaqueteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/detallepaquete")
@Tag(name = "Detalle-Paquete")
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
	
	@DeleteMapping("/eliminar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String eliminarDetallePaquete(@RequestBody DetallePaquete detallePaquete) {
        try {
            service.eliminarDetallePaquete(detallePaquete);
            return "Eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar detalle del paquete. \n" + "Más información: " + e;
        }
    }

}
