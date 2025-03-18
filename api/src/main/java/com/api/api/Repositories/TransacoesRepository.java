package com.api.api.Repositories;

import com.api.api.Entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacao, Integer> {

    @Query(nativeQuery = true, value = "select * from transacoes where categoria = :categoria")
    List<Transacao> findByCategoria(@Param("categoria") String categoria);

    @Query(nativeQuery = true, value = "select * from transacoes where status = :status")
    List<Transacao> findByStatus(@Param("status") String status);

    @Query(nativeQuery = true, value = "select * from transacoes where status = :status and categoria = :categoria")
    List<Transacao> findByStatusECategoria(@Param("status") String status, @Param("categoria") String categoria);

}
