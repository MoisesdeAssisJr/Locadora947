package services;

import model.Cliente;
import model.Produto;
import model.VHS;

import java.math.BigDecimal;

public interface LocadoraService {

    void rebobinar(VHS produto);

    void aplicarMultaPorNaoRebobinar(Cliente cliente, VHS produto);

    void aplicarMultaPorDanificar(Cliente cliente, Produto produto);

    void cobrarDoClienteDiasDeAluguel(Cliente cliente, Produto produto, int diasDeAluguel);



}
