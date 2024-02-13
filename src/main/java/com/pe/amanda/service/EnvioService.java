package com.pe.amanda.service;

import com.pe.amanda.dto.EnvioDTO;
import com.pe.amanda.model.*;
import com.pe.amanda.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Autowired
    private DetallePaqueteRepository detallePaqueteRepository;

    @Autowired
    private DestinatarioRepository destinatarioRepository;

    @Autowired
    private RemitenteRepository remitenteRepository;

    @Autowired
    private RemitenteService remitenteService;

    @Autowired
    private DestinatarioService destinatarioService;

    @Autowired
    private PaqueteService paqueteService;

    public List<Envio> listarEnvio(Integer id_guia) {
        return envioRepository.listarEnvio(id_guia);
    }

    public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public String eliminarEnvio(Envio envio) {
        if (!envioRepository.existsById(envio.getIdGuia())) {
            throw new EntityNotFoundException("No existe un remitente con el id " + envio.getIdGuia());
        }
        envioRepository.eliminarEnvio(envio.getIdGuia());

        return null;
    }

    public void crearEnvio(EnvioDTO envioDTO) {
        Envio envio = new Envio();
        envio.setOrigen(envioDTO.getOrigen());
        envio.setDestino(envioDTO.getDestino());
        envio.setEstado(envioDTO.getEstado());
        envio.setObservaciones(envioDTO.getObservaciones());

//        Agregar destinatario (con validación)
        Integer destinatarioDB = destinatarioService.existeDestinatario(envioDTO.getDestinatario());
        if (destinatarioDB != null) {
            Destinatario destinatario = envioDTO.getDestinatario();
            destinatario.setIdDestinatario(destinatarioDB);
            envio.setDestinatario(destinatario);
        } else {
            Destinatario destinatario = destinatarioRepository.save(envioDTO.getDestinatario());
            envio.setDestinatario(destinatario);
        }

//        Agregar remitente (con validación)
        Integer remitenteDB = remitenteService.existeRemitente(envioDTO.getRemitente());
        if (remitenteDB != null) {
            Remitente remitente = envioDTO.getRemitente();
            remitente.setIdRemitente(remitenteDB);
            envio.setRemitente(remitente);
        } else {
            Remitente remitente = remitenteRepository.save(envioDTO.getRemitente());
            envio.setRemitente(remitente);
        }

        Paquete paquete = paqueteRepository.save(envioDTO.getPaquete());
        envio.setPaquete(paquete);

        List<DetallePaquete> detallePaquetes = envioDTO.getDetallePaquete();
        for (DetallePaquete detalle : detallePaquetes) {
            detalle.setPaquete(paquete);
        }
        detallePaqueteRepository.saveAll(detallePaquetes);

        envioRepository.save(envio);
    }

    public String actualizarEnvio(Envio envio) {
        if (!envioRepository.existsById(envio.getIdGuia())) {
            throw new EntityNotFoundException("No existe un envío con el id " + envio.getIdGuia());
        }
        envioRepository.actualizarEnvio(envio.getIdGuia(), envio.getDestino(), envio.getEstado(), envio.getObservaciones(), envio.getOrigen());
        return null;
    }
}
