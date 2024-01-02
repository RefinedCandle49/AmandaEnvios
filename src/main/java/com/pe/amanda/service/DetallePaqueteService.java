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
}
