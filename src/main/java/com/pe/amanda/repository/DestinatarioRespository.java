package com.pe.amanda.repository;

import com.pe.amanda.model.Destinatario;
import com.pe.amanda.model.Remitente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinatarioRespository extends CrudRepository<Destinatario, String> {
    @Query(value = "{call amandaenvios.sp_ListarDestinatarios()}", nativeQuery = true)
    public List<Destinatario> listarDestinatario();
}
