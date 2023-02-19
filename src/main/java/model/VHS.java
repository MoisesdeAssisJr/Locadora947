package model;

import java.math.BigDecimal;

public class VHS extends Produto{

    public Boolean isRebobinado = true;

    public VHS () {
    }

    public VHS(int id, String nome) {
        super(id, nome);
    }

    public VHS(int id, String nome, BigDecimal precoAluguel, Boolean isAlugado) {
        super(id, nome, precoAluguel, isAlugado);
    }

    public Boolean getRebobinado() {
        return isRebobinado;
    }

    public void setRebobinado(Boolean rebobinado) {
        isRebobinado = rebobinado;
    }

    public Boolean VHSRebobinadoAtivo (Boolean statusRebobinado){
        isRebobinado = statusRebobinado;
        return isRebobinado;

    }
}
