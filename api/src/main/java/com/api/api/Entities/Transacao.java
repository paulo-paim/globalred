package com.api.api.Entities;


import com.api.api.Records.TransacaoRecord;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacao_seq")
    @SequenceGenerator(name = "transacao_seq", sequenceName = "transacao_sequence", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private LocalDateTime data_transacao;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String status;


    public Transacao(Integer id, String cliente, float valor, LocalDateTime data_transacao, String categoria, String status) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.data_transacao = data_transacao;
        this.categoria = categoria;
        this.status = status;
    }

    public Transacao(TransacaoRecord record){
        this.cliente = record.cliente();
        this.valor = record.valor();
        this.data_transacao = record.data_transacao();
        this.categoria = record.categoria();
        this.status = record.status();
    }

    public Transacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(LocalDateTime data_transacao) {
        this.data_transacao = data_transacao;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}




