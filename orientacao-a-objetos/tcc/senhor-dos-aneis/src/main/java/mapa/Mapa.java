package mapa;

import mapa.exception.*;
import personagem.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mapa {
    public static final int NUM_MAX_POSICOES = 10;

    private final Map<Integer, Personagem> personagens = new TreeMap<>();

    public List<Integer> getPosicoes() {
        return new ArrayList<>(this.personagens.keySet());
    }

    public int getNumeroPersonagens() {
        return this.personagens.size();
    }

    public int buscarPosicao(Personagem personagem) {
        for (Map.Entry<Integer, Personagem> entrada : this.personagens.entrySet()) {
            if (entrada.getValue().equals(personagem)) {
                return entrada.getKey();
            }
        }

        String mensagem = String.format("O personagem \"%s\" não existe no mapa.", personagem);
        throw new PersonagemNaoEncontradoNoMapaException(mensagem);
    }

    public Personagem buscarCasa(int posicao) {
        return this.personagens.get(posicao);
    }

    public void inserir(int posicao, Personagem personagem) {
        if (this.personagens.size() == NUM_MAX_POSICOES) {
            String mensagem = "O mapa não contém mais posições livres.";
            throw new MapaCheioException(mensagem);
        }

        if (this.personagens.containsKey(posicao)) {
            String mensagem = String.format("Já existe um personagem na posição %d.", posicao);
            throw new PosicaoOcupadaException(mensagem);
        }

        if (this.personagens.containsValue(personagem)) {
            String mensagem = String.format("O personagem \"%s\" já existe no mapa.", personagem);
            throw new PersonagemJaEstaNoMapaException(mensagem);
        }

        this.personagens.put(posicao, personagem);
    }

    public Personagem remover(int posicao) {
        if (!this.personagens.containsKey(posicao)) {
            String mensagem = String.format("Não existe nenhum personagem na posição %d.", posicao);
            throw new PosicaoSemPersonagemException(mensagem);
        }

        return this.personagens.remove(posicao);
    }

    public String exibir() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("|");

        for (int posicao = 0; posicao < NUM_MAX_POSICOES; posicao++) {
            Personagem personagem = this.personagens.get(posicao);
            String letraPersonagem = personagem == null ? " " : personagem.getLetra();

            String string = String.format("%s|", letraPersonagem);
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    private boolean sociedadeDoAnelVenceu() {
        Personagem personagem = this.personagens.get(NUM_MAX_POSICOES - 1);
        return personagem != null && personagem.fazParteDaSociedadeDoAnel();
    }

    private boolean sauronVenceu() {
        for (Personagem personagem : this.personagens.values()) {
            if (personagem.fazParteDaSociedadeDoAnel()) {
                return false;
            }
        }

        String mensagem = "A humanidade sofre perante a tirania de Sauron.";
        throw new SauronDominaOMundoException(mensagem);
    }

    public boolean temVencedor() {
        return this.sociedadeDoAnelVenceu() || this.sauronVenceu();
    }
}
