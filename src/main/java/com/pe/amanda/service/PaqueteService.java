package com.pe.amanda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.amanda.model.Paquete;
import com.pe.amanda.repository.PaqueteRepository;

@Service
public class PaqueteService {
	
	@Autowired
	PaqueteRepository paqueteRepository;
	
	public void registrarPaquete(Paquete paquete) {
		paqueteRepository.registrarPaquete(paquete.getIdPaquete(), paquete.getMedidas(), paquete.getPeso());
    }
	
	public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }
	
	public String eliminarPaquete(Paquete paquete) {
        if (!paqueteRepository.existsById(String.valueOf(paquete.getIdPaquete()))) {
            throw new EntityNotFoundException("No existe un paquete con el id " + paquete.getIdPaquete());
        }
        paqueteRepository.eliminarPaquete(paquete.getIdPaquete());

        return null;
    }

}
