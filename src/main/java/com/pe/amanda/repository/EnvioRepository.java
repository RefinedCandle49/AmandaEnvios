package com.pe.amanda.repository;

import com.pe.amanda.model.Envio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends CrudRepository<Envio, String> {
    @Query(value = "{call amandaenvios.sp_ListarEnvio(:id_guia)}", nativeQuery = true)
    public List<Envio> listarEnvio(@Param("id_guia")Integer id_guia);

    @Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_EliminarEnvio(:id_guia)}", nativeQuery = true)
    public void eliminarEnvio(
            @Param("id_guia")Integer id_guia
    );
}
