package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "remitente")
public class Remitente {
    @Id
    @Column(name = "idRemitente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRemitente;
    @Column(name = "nombreRemitente", length = 255, nullable = false)
    private String nombreRemitente;
    @Column(name = "dniRemitente", length = 8, nullable = false)
    private String dniRemitente;
    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    public Remitente() {
    }
}
