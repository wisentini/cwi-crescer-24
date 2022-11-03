package mapa.exception;

public class PersonagemJaEstaNoMapaException extends RuntimeException {
    public PersonagemJaEstaNoMapaException(String mensagem) {
        super(mensagem);
    }
}
