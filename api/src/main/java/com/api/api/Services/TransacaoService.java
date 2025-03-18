package com.api.api.Services;

import com.api.api.Entities.Transacao;
import com.api.api.Records.TransacaoRecord;
import com.api.api.Repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacoesRepository repository;

    public List<Transacao> buscarPorCategoria(String categoria){
        return this.repository.findByCategoria(categoria);
    }

    public List<Transacao> buscarPorStatus(String status){
        return this.repository.findByStatus(status);
    }

    public void novaTransacao(TransacaoRecord record){
        Transacao novaTransacao = new Transacao(record);
        this.repository.save(novaTransacao);
    }

    public List<Transacao> buscarPorStatusECategoria(String status, String categoria){
        return this.repository.findByStatusECategoria(status,categoria);
    }


}
