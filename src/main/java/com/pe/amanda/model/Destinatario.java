package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Data;
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
    @Column(name = "nombreDestinatario")
    private String nombreDestinatario;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
}
