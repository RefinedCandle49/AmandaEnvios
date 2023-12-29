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

    public List<Remitente> listarRemitentes(){
        return remitenteRepository.listarRemitentes();
    }



}
