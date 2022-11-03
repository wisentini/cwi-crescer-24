package dicionario;

import dicionario.exception.PalavraNaoEncontradaException;

import java.util.Map;
import java.util.TreeMap;

public class Dicionario {
    private final Map<String, String> dicionarioPortugues;
    private final Map<String, String> dicionarioIngles;

    public Dicionario() {
        this.dicionarioPortugues = new TreeMap<>();
        this.dicionarioIngles = new TreeMap<>();
    }

    private Map<String, String> getDicionario(TipoDicionario tipoDicionario) {
        return switch (tipoDicionario) {
            case PORTUGUES -> this.dicionarioPortugues;
            case INGLES -> this.dicionarioIngles;
        };
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario tipoDicionario) {
        Map<String, String> dicionario = this.getDicionario(tipoDicionario);
        String palavraMinuscula = palavra.toLowerCase();
        dicionario.put(palavraMinuscula, traducao);
    }

    public String traduzir(String palavra, TipoDicionario tipoDicionario) {
        Map<String, String> dicionario = this.getDicionario(tipoDicionario);
        String palavraMinuscula = palavra.toLowerCase();
        String traducao = dicionario.get(palavraMinuscula);

        if (traducao == null) {
            String mensagem = String.format("A palavra \"%s\" não foi encontrada no dicionário.", palavra);
            throw new PalavraNaoEncontradaException(mensagem);
        }

        return traducao;
    }
}
