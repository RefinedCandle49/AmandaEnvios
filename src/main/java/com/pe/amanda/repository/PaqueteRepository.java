package com.pe.amanda.repository;

import com.pe.amanda.model.Paquete;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaqueteRepository extends JpaRepository<Paquete, String> {

    Paquete findByPesoAndMedidas(double peso, String medidas);
	
	@Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_EliminarPaquete(:idPaquete)}", nativeQuery = true)
    public void eliminarPaquete(
            @Param("idPaquete")Integer idPaquete
    );

}
