package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "destinatario")
public class Destinatario {
    @Id
    @Column(name = "idDestinatario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDestinatario;

    @Column(name = "nombreDestinatario", length = 255, nullable = false)
    private String nombreDestinatario;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @Column(name = "telefono", length = 255, nullable = false)
    private String telefono;

}
