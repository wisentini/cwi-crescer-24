package personagem.classe.guerreiro;

import mapa.Mapa;
import personagem.Personagem;

public abstract class Guerreiro extends Personagem {
    protected Guerreiro(int forca, int agilidade, int inteligencia, int constituicao, String letra, boolean fazParteDaSociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, letra, fazParteDaSociedadeDoAnel);
    }

    @Override
    public void movimentar(Mapa mapa) {
        int posicaoAtual = mapa.buscarPosicao(this);
        int direcaoDeslocamento = this.getDirecaoDeslocamento();
        int posicaoNova = posicaoAtual + direcaoDeslocamento;

        if (mapa.buscarCasa(posicaoNova) == null) {
            mapa.remover(posicaoAtual);
            mapa.inserir(posicaoNova, this);
        }
    }

    private void atacar(Mapa mapa, int posicaoPersonagem) {
        Personagem personagem = mapa.buscarCasa(posicaoPersonagem);
        int dano = this.forca * 2;

        if (personagem != null && personagem.ehInimigo(this)) {
            personagem.receberAtaque(dano);

            if (personagem.foiDestruido()) {
                mapa.remover(posicaoPersonagem);
            }
        }
    }

    @Override
    public void atacar(Mapa mapa) {
        int posicao = mapa.buscarPosicao(this);
        this.atacar(mapa, posicao - 1);
        this.atacar(mapa, posicao + 1);
    }
}
