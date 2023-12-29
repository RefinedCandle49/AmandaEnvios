package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "detallepaquete")
public class DetallePaquete {
    @Id
    @Column(name = "idDetallePaquete")
    private int idDetallePaquete;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idPaquete")
    private Paquete paquete;
}
