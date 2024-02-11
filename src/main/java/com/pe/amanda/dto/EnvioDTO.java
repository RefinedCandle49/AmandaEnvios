package com.pe.amanda.dto;

import com.pe.amanda.model.Destinatario;
import com.pe.amanda.model.DetallePaquete;
import com.pe.amanda.model.Paquete;
import com.pe.amanda.model.Remitente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EnvioDTO {
    private String origen;
    private String destino;
    private String estado;
    private String observaciones;
    private Paquete paquete;
    private Destinatario destinatario;
    private Remitente remitente;
    private List<DetallePaquete> detallePaquete;


}