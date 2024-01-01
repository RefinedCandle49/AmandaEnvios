package com.pe.amanda.service;

import com.pe.amanda.model.Destinatario;
import com.pe.amanda.model.Remitente;
import com.pe.amanda.repository.DestinatarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinatarioService {
    @Autowired
    DestinatarioRespository destinatarioRespository;

    public List<Destinatario> listarDestinatarios() {
        return destinatarioRespository.listarDestinatario();
    }
}
