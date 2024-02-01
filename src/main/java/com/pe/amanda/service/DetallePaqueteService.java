package com.pe.amanda.service;

import com.pe.amanda.model.DetallePaquete;
import com.pe.amanda.repository.DetallePaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePaqueteService {
    @Autowired
    DetallePaqueteRepository detallePaqueteRepository;

    public List<DetallePaquete> listarDetallePaquete(Integer paquete_id_paquete){
        return detallePaqueteRepository.listarDetallePaquete(paquete_id_paquete);
    }

    public void registrarDetallePaquete(DetallePaquete detallePaquete) {
    	detallePaqueteRepository.registrarDetallePaquete(detallePaquete.getIdDetallePaquete(), detallePaquete.getCantidad(), detallePaquete.getDescripcion(), detallePaquete.getPaquete().getIdPaquete());
    }
	
	public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }
	
	public String eliminarDetallePaquete(DetallePaquete detallePaquete) {
        if (!detallePaqueteRepository.existsById(String.valueOf(detallePaquete.getIdDetallePaquete()))) {
            throw new EntityNotFoundException("No existe un Detalle de Paquete con el id " + detallePaquete.getIdDetallePaquete());
        }
        detallePaqueteRepository.eliminarDetallePaquete(detallePaquete.getIdDetallePaquete());

        return null;
    }
}
