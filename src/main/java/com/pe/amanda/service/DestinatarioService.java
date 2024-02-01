package com.pe.amanda.service;

import com.pe.amanda.model.Destinatario;
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

    public void registrarDestinatario(Destinatario destinatario) {
        destinatarioRespository.registrarDestinatario(destinatario.getIdDestinatario(), destinatario.getNombreDestinatario(), destinatario.getDireccion(), destinatario.getTelefono());
    }

    public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public String actualizarDestinatario(Destinatario destinatario) {
        if (!destinatarioRespository.existsById(String.valueOf(destinatario.getIdDestinatario()))) {
            throw new EntityNotFoundException("No existe un destinatario con el id " + destinatario.getIdDestinatario());
        }
        destinatarioRespository.actualizarDestinatario(destinatario.getIdDestinatario(), destinatario.getDireccion(), destinatario.getNombreDestinatario(), destinatario.getTelefono());

        return null;
    }

    public String eliminarDestinatario(Destinatario destinatario) {
        if (!destinatarioRespository.existsById(String.valueOf(destinatario.getIdDestinatario()))) {
            throw new EntityNotFoundException("No existe un destinatario con el id " + destinatario.getIdDestinatario());
        }
        destinatarioRespository.eliminarDestinatario(destinatario.getIdDestinatario());

        return null;
    }
}
