package com.etl.etl.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.time.LocalDateTime;


@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    private Integer id;

    @NotNull
    private String cliente;

    @NotNull
    private float valor;

    @NotNull
    private LocalDateTime data_transacao;

    @NotNull
    private String categoria;

    @NotNull
    private String status;


    public Transacao(Integer id, String cliente, float valor, LocalDateTime data_transacao, String categoria, String status) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.data_transacao = data_transacao;
        this.categoria = categoria;
        this.status = status;
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



