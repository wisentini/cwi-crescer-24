package personagem.classe.arqueiro;

import mapa.Mapa;
import personagem.Personagem;

public abstract class Arqueiro extends Personagem {
    protected Arqueiro(int forca, int agilidade, int inteligencia, int constituicao, String letra, boolean fazParteDaSociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, letra, fazParteDaSociedadeDoAnel);
    }

    private int encontrarPosicaoNova(int posicaoAtual, Mapa mapa) {
        int direcaoDeslocamento = this.getDirecaoDeslocamento();
        int posicaoNova = posicaoAtual;

        for (int distancia = 1; distancia <= 2; distancia++) {
            int proximaPosicao = posicaoAtual + (distancia * direcaoDeslocamento);

            if (mapa.buscarCasa(proximaPosicao) == null) {
                posicaoNova = proximaPosicao;
            } else if (distancia == 1) {
                return posicaoNova;
            }
        }

        return posicaoNova;
    }

    @Override
    public void movimentar(Mapa mapa) {
        int posicaoAtual = mapa.buscarPosicao(this);
        int posicaoNova = this.encontrarPosicaoNova(posicaoAtual, mapa);

        if (posicaoNova != posicaoAtual) {
            mapa.remover(posicaoAtual);
            mapa.inserir(posicaoNova, this);
        }
    }

    private Personagem encontrarInimigo(int posicaoAtual, Mapa mapa) {
        int direcaoDeslocamento = this.getDirecaoDeslocamento();

        for (int distancia = 3; distancia >= 1; distancia--) {
            int proximaPosicao = posicaoAtual + (distancia * direcaoDeslocamento);
            Personagem personagem = mapa.buscarCasa(proximaPosicao);

            if (personagem != null && personagem.ehInimigo(this)) {
                return personagem;
            }
        }

        return null;
    }

    @Override
    public void atacar(Mapa mapa) {
        int posicaoAtual = mapa.buscarPosicao(this);
        Personagem inimigo = this.encontrarInimigo(posicaoAtual, mapa);

        if (inimigo != null) {
            int posicaoInimigo = mapa.buscarPosicao(inimigo);
            int distancia = Math.abs(posicaoInimigo - posicaoAtual);
            int dano = distancia * this.agilidade;

            inimigo.receberAtaque(dano);

            if (inimigo.foiDestruido()) {
                mapa.remover(posicaoInimigo);
            }
        }
    }
}
