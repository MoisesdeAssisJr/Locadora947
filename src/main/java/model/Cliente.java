package model;

import java.math.BigDecimal;

public class Cliente {

    int id;
    String nome;
    Endereco endereco;

    BigDecimal multaDevidaPorNaoRebobinar = BigDecimal.ZERO;

    BigDecimal multaDevidaPorDanificar = BigDecimal.ZERO;

    BigDecimal valorDevidoPorAluguel = BigDecimal.ZERO;


    public Cliente() {
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(int id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getMultaDevidaPorNaoRebobinar() {
        return multaDevidaPorNaoRebobinar;
    }

    public void setMultaDevidaPorNaoRebobinar(BigDecimal multaDevidaPorNaoRebobinar) {
        this.multaDevidaPorNaoRebobinar = multaDevidaPorNaoRebobinar;
    }

    public BigDecimal getMultaDevidaPorDanificar() {
        return multaDevidaPorDanificar;
    }

    public void setMultaDevidaPorDanificar(BigDecimal multaDevidaPorDanificar) {
        this.multaDevidaPorDanificar = multaDevidaPorDanificar;
    }

    public BigDecimal getValorDevidoPorAluguel() {
        return valorDevidoPorAluguel;
    }

    public void setValorDevidoPorAluguel(BigDecimal valorDevidoPorAluguel) {
        this.valorDevidoPorAluguel = valorDevidoPorAluguel;
    }
}
