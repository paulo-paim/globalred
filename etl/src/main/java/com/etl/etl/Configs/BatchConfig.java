package com.etl.etl.Configs;

import com.etl.etl.Entities.Transacao;
import com.etl.etl.Repositories.TransacaoRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Job importTransacoes(JobRepository jobRepository, Step step1){
        return new JobBuilder("importTransacoes", jobRepository)
                .incrementer(new org.springframework.batch.core.launch.support.RunIdIncrementer())
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                      FlatFileItemReader<Transacao> reader,
                      ItemProcessor<Transacao, Transacao> processor,
                      ItemWriter<Transacao> writer){

        return new StepBuilder("step1", jobRepository)
                .<Transacao, Transacao>chunk(700, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

    }
}
