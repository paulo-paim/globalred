package com.api.api.Repositories;


import com.api.api.Entities.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacao, Integer> {

    Page<Transacao> findByStatus(String status, Pageable pageable);

    Page<Transacao> findByCategoria(String categoria, Pageable pageable);

    Page<Transacao> findByStatusAndCategoria(String status, String categoria, Pageable pageable);


}
