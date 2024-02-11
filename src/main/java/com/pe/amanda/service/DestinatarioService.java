package com.pe.amanda.service;

import com.pe.amanda.model.Destinatario;
import com.pe.amanda.repository.DestinatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinatarioService {
    @Autowired
    DestinatarioRepository destinatarioRepository;

    public Destinatario saveDestinatario(Destinatario destinatario) {
        return destinatarioRepository.save(destinatario);
    }

    public Integer existeDestinatario(Destinatario destinatario){
        Destinatario destinatario1 = destinatarioRepository.findByNombreDestinatarioAndDireccionAndTelefono(destinatario.getNombreDestinatario(), destinatario.getDireccion(), destinatario.getTelefono());
        return destinatario1!=null ? destinatario1.getIdDestinatario():null;
    }

    public List<Destinatario> listarDestinatarios() {
        return destinatarioRepository.listarDestinatario();
    }

    public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public String actualizarDestinatario(Destinatario destinatario) {
        if (!destinatarioRepository.existsById(String.valueOf(destinatario.getIdDestinatario()))) {
            throw new EntityNotFoundException("No existe un destinatario con el id " + destinatario.getIdDestinatario());
        }
        destinatarioRepository.actualizarDestinatario(destinatario.getIdDestinatario(), destinatario.getDireccion(), destinatario.getNombreDestinatario(), destinatario.getTelefono());

        return null;
    }

    public String eliminarDestinatario(Destinatario destinatario) {
        if (!destinatarioRepository.existsById(String.valueOf(destinatario.getIdDestinatario()))) {
            throw new EntityNotFoundException("No existe un destinatario con el id " + destinatario.getIdDestinatario());
        }
        destinatarioRepository.eliminarDestinatario(destinatario.getIdDestinatario());

        return null;
    }
}
