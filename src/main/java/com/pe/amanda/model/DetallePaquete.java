package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "detallePaquete")

public class DetallePaquete {
    @Id
    @Column(name = "idDetallePaquete", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetallePaquete;
    @Column(name = "idPaquete", nullable = false)
    @OneToOne
    private Integer idPaquete;
    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;
    public DetallePaquete(){
    }
}
