package services;

import model.Cliente;
import model.Locadora;
import model.Produto;
import model.VHS;

import java.math.BigDecimal;

public interface ClienteService {

    void alugar(Produto produto);

    void devolver(Cliente cliente, Produto produto, int diasDeAluguel);

    void rebobinar(VHS produto);

    void pagar(Cliente cliente, Locadora locadora);

}

