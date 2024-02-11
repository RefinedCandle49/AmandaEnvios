package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "paquete")
public class Paquete {
    @Id
    @Column(name = "idPaquete")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaquete;
    @Column(name = "peso", nullable = false)
    private double peso;
    @Column(name = "medidas", length = 50, nullable = false)
    private String medidas;

}
