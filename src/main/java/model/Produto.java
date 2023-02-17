package model;

import java.math.BigDecimal;

public abstract class Produto {

    int id;
    String nome;

    BigDecimal precoAluguel = BigDecimal.valueOf(5.00);
    public Boolean isAlugado = false;

    public Boolean isDanificado = false;

    public Produto() {

    }

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Produto(int id, String nome, BigDecimal precoAluguel, Boolean isAlugado) {
        this.id = id;
        this.nome = nome;
        this.precoAluguel = precoAluguel;
        this.isAlugado = isAlugado;
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

    public BigDecimal getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(BigDecimal precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public Boolean getAlugado() {
        return isAlugado;
    }

    public void setAlugado(Boolean alugado) {
        isAlugado = alugado;
    }

    public Boolean getDanificado() {
        return isDanificado;
    }

    public void setDanificado(Boolean danificado) {
        isDanificado = danificado;
    }
}
