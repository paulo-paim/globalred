package com.etl.etl.Configs;

import com.etl.etl.Entities.Transacao;
import com.etl.etl.Utils.Normalizador;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProcessorTransacao implements ItemProcessor<Transacao, Transacao> {


    @Override
    public Transacao process(Transacao item) throws Exception {

        item.setCliente(Normalizador.normalizar(item.getCliente().toUpperCase()));
        item.setCategoria(Normalizador.normalizar(item.getCategoria().toUpperCase()));
        item.setStatus(item.getStatus().toUpperCase());

        return item;
    }
}
