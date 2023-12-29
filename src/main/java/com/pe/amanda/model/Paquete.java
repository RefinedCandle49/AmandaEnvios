package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "paquete")
public class Paquete {
    @Id
    @Column(name = "idPaquete")
    private int idPaquete;
    @Column(name = "peso")
    private double peso;
    @Column(name = "medidas")
    private String medidas;
}
