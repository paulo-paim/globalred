package com.etl.etl.Configs;

import com.etl.etl.Entities.Transacao;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ReaderTransacao {

    @Bean
    public FlatFileItemReader<Transacao> reader(){
        return new FlatFileItemReaderBuilder<Transacao>()
                .name("transacaoItemReader")
                .resource(new FileSystemResource("C:/transacoes_input.csv"))
                .delimited()
                .names("id","cliente","valor","data_transacao","categoria","status")
                .linesToSkip(1)
                .fieldSetMapper(fieldSet -> {
                    Transacao transacao = new Transacao();
                    transacao.setId(fieldSet.readInt("id"));
                    transacao.setCliente(fieldSet.readString("cliente"));
                    transacao.setValor(fieldSet.readFloat("valor"));
                    transacao.setData_transacao(LocalDateTime.parse(fieldSet.readString("data_transacao"),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    transacao.setCategoria(fieldSet.readString("categoria"));
                    transacao.setStatus(fieldSet.readString("status"));
                    return transacao;
                })
                .build();
    }

}
