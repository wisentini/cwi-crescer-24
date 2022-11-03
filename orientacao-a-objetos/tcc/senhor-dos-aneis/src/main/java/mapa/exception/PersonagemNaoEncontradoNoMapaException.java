package mapa.exception;

public class PersonagemNaoEncontradoNoMapaException extends RuntimeException {
    public PersonagemNaoEncontradoNoMapaException(String mensagem) {
        super(mensagem);
    }
}
