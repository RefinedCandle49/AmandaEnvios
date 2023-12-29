package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "remitente")
public class Remitente {
    @Id
    @Column(name = "idRemitente")
    private int idRemitente;
    @Column(name = "nombreRemitente")
    private String nombreRemitente;
    @Column(name = "dniRemitente")
    private String dniRemitente;
    @Column(name = "telefono")
    private String telefono;
}