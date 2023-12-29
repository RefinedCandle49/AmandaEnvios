package com.pe.amanda.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "envio")
public class Envio {
    @Id
    @Column(name = "idGuia", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGuia;
    @Column(name = "idRemitente", nullable = false)
    @OneToOne
    private Integer idRemitente;
    @Column(name = "idDestinatario", nullable = false)
    @OneToOne
    private Integer idDestinatario;
    @Column(name = "idPaquete", nullable = false)
    @OneToOne
    private Integer idPaquete;
    @Column(name = "origen", length = 255, nullable = false)
    private String origen;
    @Column(name = "destino", length = 255, nullable = false)
    private String destino;
    @Column(name = "estado", length = 255, nullable = false)
    private String estado;
}
