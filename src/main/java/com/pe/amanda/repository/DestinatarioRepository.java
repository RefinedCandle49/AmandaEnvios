package com.pe.amanda.repository;

import com.pe.amanda.model.Destinatario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, String> {

    Destinatario findByNombreDestinatarioAndDireccionAndTelefono(String nombreDestinatario, String direccion, String telefono);

    @Query(value = "{call amandaenvios.sp_ListarDestinatarios()}", nativeQuery = true)
    public List<Destinatario> listarDestinatario();

    @Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_ActualizarDestinatario(:id_destinatario, :direccion, :nombre_destinatario, :telefono)}", nativeQuery = true)
    public void actualizarDestinatario(
            @Param("id_destinatario")Integer id_destinatario,
            @Param("direccion")String direccion,
            @Param("nombre_destinatario")String nombre_destinatario,
            @Param("telefono")String telefono
    );

    @Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_EliminarDestinatario(:id_destinatario)}", nativeQuery = true)
    public void eliminarDestinatario(
            @Param("id_destinatario")Integer id_destinatario
    );
}
