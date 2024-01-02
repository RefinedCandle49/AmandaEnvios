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
}
