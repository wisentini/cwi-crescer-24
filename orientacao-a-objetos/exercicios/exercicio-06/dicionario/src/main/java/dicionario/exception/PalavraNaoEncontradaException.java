package dicionario.exception;

public class PalavraNaoEncontradaException extends RuntimeException {
    public PalavraNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
