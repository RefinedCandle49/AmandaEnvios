package com.pe.amanda.service;

import com.pe.amanda.model.Envio;
import com.pe.amanda.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService{

    @Autowired
    EnvioRepository envioRepository;

    public List<Envio> listarEnvio(Integer id_guia){
        return envioRepository.listarEnvio(id_guia);
    }

    public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public String eliminarEnvio(Envio envio){
        if (!envioRepository.existsById(String.valueOf(envio.getIdGuia()))) {
            throw new EntityNotFoundException("No existe un remitente con el id " + envio.getIdGuia());
        }
        envioRepository.eliminarEnvio(envio.getIdGuia());

        return null;
    }
}
