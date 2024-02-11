package com.pe.amanda.repository;

import com.pe.amanda.model.Remitente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemitenteRepository extends JpaRepository<Remitente, String> {

    Remitente findByNombreRemitenteAndDniRemitenteAndTelefono(String nombreRemitente,String dni, String telefono);
    @Query(value = "{call amandaenvios.sp_ListarRemitentes()}", nativeQuery = true)
    public List<Remitente> listarRemitentes();

    @Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_RegistrarRemitente(:idRemitente, :dniRemitente, :nombreRemitente, :telefono)}", nativeQuery = true)
    void registrarRemitente(
            @Param("idRemitente")Integer idRemitente,
            @Param("dniRemitente")String dniRemitente,
            @Param("nombreRemitente")String nombreRemitente,
            @Param("telefono")String telefono
    );

    @Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_ActualizarRemitente(:idRemitente, :dniRemitente, :nombreRemitente, :telefono)}", nativeQuery = true)
    public void actualizarRemitente(
            @Param("idRemitente")Integer idRemitente,
            @Param("dniRemitente")String dniRemitente,
            @Param("nombreRemitente")String nombreRemitente,
            @Param("telefono")String telefono
    );

    @Transactional
    @Modifying
    @Query(value = "{call amandaenvios.sp_EliminarRemitente(:idRemitente)}", nativeQuery = true)
    public void eliminarRemitente(
            @Param("idRemitente")Integer idRemitente
    );

}
