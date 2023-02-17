package exceptions;

public class ImpossivelRebobinarVHSJaRebobinado extends RuntimeException {

    public ImpossivelRebobinarVHSJaRebobinado() {
        super("Impossível rebobinar VHS já rebobinado.");
    }
}
