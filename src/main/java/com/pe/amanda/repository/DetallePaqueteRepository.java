package com.pe.amanda.repository;

import com.pe.amanda.model.DetallePaquete;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePaqueteRepository extends JpaRepository<DetallePaquete, String> {
    @Query(value = "{call amandaenvios.sp_ListarDetallePaquete(:paquete_id_paquete)}", nativeQuery = true)
    public List<DetallePaquete> listarDetallePaquete(@Param("paquete_id_paquete")Integer paquete_id_paquete);
	
	@Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_EliminarDetallePaquete(:id_detalle_paquete)}", nativeQuery = true)
    public void eliminarDetallePaquete(
            @Param("id_detalle_paquete")Integer id_detalle_paquete
    );
}
