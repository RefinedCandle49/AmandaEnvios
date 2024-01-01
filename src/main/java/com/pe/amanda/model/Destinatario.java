package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "destinatario")
public class Destinatario {
    @Id
    @Column(name = "idDestinatario")
    private int idDestinatario;
    @Column(name = "nombreDestinatario", length = 100, nullable = false)
    private String nombreDestinatario;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;
}
