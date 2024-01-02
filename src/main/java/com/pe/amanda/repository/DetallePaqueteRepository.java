package com.pe.amanda.repository;

import com.pe.amanda.model.DetallePaquete;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePaqueteRepository extends CrudRepository<DetallePaquete, String> {
    @Query(value = "{call amandaenvios.sp_ListarDetallePaquete(:paquete_id_paquete)}", nativeQuery = true)
    public List<DetallePaquete> listarDetallePaquete(@Param("paquete_id_paquete")Integer paquete_id_paquete);
}
