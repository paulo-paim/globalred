package com.etl.etl.Configs;

import com.etl.etl.Entities.Transacao;
import com.etl.etl.Repositories.TransacaoRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterTransacao {

    @Bean
    public ItemWriter<Transacao> writer(TransacaoRepository transacaoRepository){
        return transacaoRepository::saveAll;
    }

}
