package exceptions;

public class ProdutoNaoFoiAlugadoException extends RuntimeException {

    public ProdutoNaoFoiAlugadoException() {
        super("Produto não foi alugado. Informe o produto alugado para devolução.");
    }
}

