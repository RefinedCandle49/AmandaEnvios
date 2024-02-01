package com.pe.amanda.repository;

import com.pe.amanda.model.Paquete;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaqueteRepository extends CrudRepository<Paquete, String>{
	
	@Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_RegistrarPaquete(:idPaquete, :medidas, :peso)}", nativeQuery = true)
    void registrarPaquete(
            @Param("idPaquete")Integer idPaquete,
            @Param("medidas")String medidas,
            @Param("peso")Double peso
    );
	
	@Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_EliminarPaquete(:idPaquete)}", nativeQuery = true)
    public void eliminarPaquete(
            @Param("idPaquete")Integer idPaquete
    );

}
