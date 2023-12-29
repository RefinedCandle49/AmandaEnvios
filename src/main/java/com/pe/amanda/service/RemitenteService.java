package com.pe.amanda.service;

import com.pe.amanda.credenciales.UserInfo;
import com.pe.amanda.model.Remitente;
import com.pe.amanda.repository.RemitenteRepository;
import com.pe.amanda.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemitenteService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RemitenteRepository remitenteRepository;

    public List<Remitente> listarRemitentes(){
        return remitenteRepository.listarRemitentes();
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }

}
