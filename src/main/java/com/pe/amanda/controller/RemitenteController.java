package com.pe.amanda.controller;

import com.pe.amanda.model.Remitente;
import com.pe.amanda.service.RemitenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remitente")
public class RemitenteController {

    @Autowired
    private RemitenteService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Remitente> listarRemitentes(){
        return service.listarRemitentes();
    }


}
