package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "envio")
public class Envio {
    @Id
    @Column(name = "idGuia")
    private int idGuia;
    @Column(name = "origen")
    private String origen;
    @Column(name = "destino")
    private String destino;
    @Column(name = "estado")
    private String estado;
    @OneToOne
//    @JoinColumn(name = "idRemitente")
    private Remitente remitente;
    @OneToOne
//    @JoinColumn(name = "idDestinatario")
    private Destinatario destinatario;
    @OneToOne
//    @JoinColumn(name = "idPaquete")
    private Paquete paquete;
}
