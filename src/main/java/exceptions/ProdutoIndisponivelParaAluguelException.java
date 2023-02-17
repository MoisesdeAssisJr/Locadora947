package exceptions;

public class ProdutoIndisponivelParaAluguelException extends RuntimeException{

    public ProdutoIndisponivelParaAluguelException() {
        super("Produto indiponível para aluguel!");
    }
}
