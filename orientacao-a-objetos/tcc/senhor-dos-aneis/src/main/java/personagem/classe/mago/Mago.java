package personagem.classe.mago;

import mapa.Mapa;
import personagem.Personagem;

public abstract class Mago extends Personagem {
    protected Mago(int forca, int agilidade, int inteligencia, int constituicao, String letra, boolean fazParteDaSociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, letra, fazParteDaSociedadeDoAnel);
    }

    @Override
    public void movimentar(Mapa mapa) {
        if (mapa.getNumeroPersonagens() != 1) return;

        int posicaoAtual = mapa.buscarPosicao(this);
        int direcaoDeslocamento = this.getDirecaoDeslocamento();
        int posicaoNova = posicaoAtual + direcaoDeslocamento;

        if (mapa.buscarCasa(posicaoNova) == null) {
            mapa.remover(posicaoAtual);
            mapa.inserir(posicaoNova, this);
        }
    }

    @Override
    public void atacar(Mapa mapa) {
        for (int posicao : mapa.getPosicoes()) {
            Personagem personagem = mapa.buscarCasa(posicao);

            if (personagem != null && personagem.ehInimigo(this)) {
                personagem.receberAtaque(this.inteligencia);

                if (personagem.foiDestruido()) {
                    mapa.remover(posicao);
                }
            }
        }
    }
}
