package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "detallepaquete")
public class DetallePaquete {
    @Id
    @Column(name = "idDetallePaquete")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetallePaquete;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    private Paquete paquete;
}
