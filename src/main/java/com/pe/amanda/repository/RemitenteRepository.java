package com.pe.amanda.repository;

import com.pe.amanda.model.Remitente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemitenteRepository extends CrudRepository<Remitente, String> {
    @Query(value = "{call amandaenvios.sp_ListarRemitentes()}", nativeQuery = true)
    public List<Remitente> listarRemitentes();
}
