package com.pe.amanda.service;

import com.pe.amanda.model.Remitente;
import com.pe.amanda.repository.RemitenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemitenteService {

    @Autowired
    RemitenteRepository remitenteRepository;

    public Remitente saveRemitente(Remitente remitente){
        return remitenteRepository.save(remitente);
    }

    public void registrarRemitente(Remitente remitente) {
        remitenteRepository.registrarRemitente(remitente.getIdRemitente(), remitente.getDniRemitente(), remitente.getNombreRemitente(), remitente.getTelefono());
    }

    public Integer existeRemitente(Remitente remitente){
        Remitente remitente1 = remitenteRepository.findByNombreRemitenteAndDniRemitenteAndTelefono(remitente.getNombreRemitente(),remitente.getDniRemitente(), remitente.getTelefono());
        return remitente1!=null ? remitente1.getIdRemitente(): null;
    }

    public List<Remitente> listarRemitentes() {
        return remitenteRepository.listarRemitentes();
    }

    public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public String actualizarRemitente(Remitente remitente) {
        if (!remitenteRepository.existsById(String.valueOf(remitente.getIdRemitente()))) {
            throw new EntityNotFoundException("No existe un remitente con el id " + remitente.getIdRemitente());
        }
        remitenteRepository.actualizarRemitente(remitente.getIdRemitente(), remitente.getDniRemitente(), remitente.getNombreRemitente(), remitente.getTelefono());

        return null;
    }

    public String eliminarRemitente(Remitente remitente) {
        if (!remitenteRepository.existsById(String.valueOf(remitente.getIdRemitente()))) {
            throw new EntityNotFoundException("No existe un remitente con el id " + remitente.getIdRemitente());
        }
        remitenteRepository.eliminarRemitente(remitente.getIdRemitente());

        return null;
    }


}
