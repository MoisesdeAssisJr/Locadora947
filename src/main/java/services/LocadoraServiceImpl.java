package services;

import exceptions.ImpossivelRebobinarVHSJaRebobinado;
import model.Cliente;
import model.Produto;
import model.VHS;

import java.math.BigDecimal;

public class LocadoraServiceImpl implements LocadoraService{
    @Override
    public void rebobinar(VHS produto) throws ImpossivelRebobinarVHSJaRebobinado{
        if (!produto.getRebobinado()) {
            produto.VHSRebobinadoAtivo(true);
        } else {
            throw new ImpossivelRebobinarVHSJaRebobinado();
        }
    }

    @Override
    public void aplicarMultaPorNaoRebobinar(Cliente cliente, VHS produto) {
        if(!produto.isRebobinado) {
            rebobinar(produto);
            cliente.setMultaDevidaPorNaoRebobinar(cliente.getMultaDevidaPorNaoRebobinar().add(produto.getPrecoAluguel().multiply(BigDecimal.valueOf(0.5))));
        }
    }

    @Override
    public void aplicarMultaPorDanificar(Cliente cliente, Produto produto) {
        if(produto.isDanificado) {
            cliente.setMultaDevidaPorDanificar(cliente.getMultaDevidaPorDanificar().add(produto.getPrecoAluguel().multiply(BigDecimal.valueOf(10))));
        }
    }

    @Override
    public void cobrarDoClienteDiasDeAluguel(Cliente cliente, Produto produto, int diasDeAluguel) {
        cliente.setValorDevidoPorAluguel(cliente.getValorDevidoPorAluguel().add(produto.getPrecoAluguel().multiply(BigDecimal.valueOf(diasDeAluguel))));
    }
}
