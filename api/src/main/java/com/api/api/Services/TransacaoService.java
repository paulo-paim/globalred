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

    public void novaTransacao(TransacaoRecord record){
        Transacao novaTransacao = new Transacao(record);
        this.repository.save(novaTransacao);
    }

    public Page<Transacao>  filtrarPorStatusOuCategoria(String status, String categoria, Pageable pageable){
        if (status != null && categoria != null) {
            return repository.findByStatusAndCategoria(status, categoria, pageable);
        } else if (status != null) {
            return repository.findByStatus(status, pageable);
        } else if (categoria != null) {
            return repository.findByCategoria(categoria, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    public Page<Transacao> listarTransacoes(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
