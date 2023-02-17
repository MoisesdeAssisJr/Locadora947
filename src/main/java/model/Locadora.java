package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Locadora {

    String nome;
    List<Produto> produtos = new ArrayList<>();

    BigDecimal caixaDeRecebimentos = BigDecimal.ZERO;


    public Locadora(String nome, List<Produto> produtos, BigDecimal caixaDeRecebimentos) {
        this.nome = nome;
        this.produtos = produtos;
        this.caixaDeRecebimentos = caixaDeRecebimentos;
    }

    public Locadora(String nome, List<Produto> produtos) {
        this.nome = nome;
        this.produtos = produtos;
    }

    public Locadora() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getCaixaDeRecebimentos() {
        return caixaDeRecebimentos;
    }

    public void setCaixaDeRecebimentos(BigDecimal caixaDeRecebimentos) {
        this.caixaDeRecebimentos = caixaDeRecebimentos;
    }
}
