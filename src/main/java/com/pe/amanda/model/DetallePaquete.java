package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "detalle_paquete")
@Data
public class DetallePaquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetallePaquete;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "paquete_id")
    private Paquete paquete;


}
