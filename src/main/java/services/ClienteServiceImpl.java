package services;

import exceptions.ImpossivelRebobinarVHSJaRebobinado;
import exceptions.ProdutoIndisponivelParaAluguelException;
import exceptions.ProdutoNaoFoiAlugadoException;
import model.Cliente;
import model.Locadora;
import model.Produto;
import model.VHS;

import java.math.BigDecimal;

public class ClienteServiceImpl implements ClienteService {
    @Override
    public void alugar(Produto produto) throws ProdutoIndisponivelParaAluguelException{
        if(!produto.isAlugado) {
            produto.setAlugado(true);
        } else {
            throw new ProdutoIndisponivelParaAluguelException();
        }
    }

    @Override
    public void devolver(Cliente cliente, Produto produto, int diasDeAluguel) throws ProdutoNaoFoiAlugadoException{
        if(produto.isAlugado) {
            produto.setAlugado(false);
            cliente.setValorDevidoPorAluguel(cliente.getValorDevidoPorAluguel().add(produto.getPrecoAluguel().multiply(BigDecimal.valueOf(diasDeAluguel))));
        } else {
            throw new ProdutoNaoFoiAlugadoException();
        }
    }

    @Override
    public void rebobinar(VHS produto) throws ImpossivelRebobinarVHSJaRebobinado {
        if (!produto.isRebobinado) {
            produto.setRebobinado(true);
        } else {
            throw new ImpossivelRebobinarVHSJaRebobinado();
        }
    }

    @Override
    public void pagar(Cliente cliente, Locadora locadora) {
        BigDecimal total = cliente.getMultaDevidaPorDanificar().add(cliente.getMultaDevidaPorNaoRebobinar()).add(cliente.getValorDevidoPorAluguel());
        locadora.setCaixaDeRecebimentos(locadora.getCaixaDeRecebimentos().add(total));
        cliente.setValorDevidoPorAluguel(BigDecimal.ZERO);
        cliente.setMultaDevidaPorDanificar(BigDecimal.ZERO);
        cliente.setMultaDevidaPorNaoRebobinar(BigDecimal.ZERO);
    }
}
