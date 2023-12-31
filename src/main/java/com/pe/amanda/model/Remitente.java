package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "remitente")
public class Remitente {
    @Id
    @Column(name = "idRemitente")
    private int idRemitente;
    @Column(name = "nombreRemitente", length = 100, nullable = false)
    private String nombreRemitente;
    @Column(name = "dniRemitente", length = 8, nullable = false)
    private String dniRemitente;
    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;;
}