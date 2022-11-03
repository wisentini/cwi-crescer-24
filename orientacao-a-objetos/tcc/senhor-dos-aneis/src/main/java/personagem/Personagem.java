package personagem;

import mapa.Mapa;

public abstract class Personagem {
    protected final int forca;
    protected final int agilidade;
    protected final int inteligencia;
    protected int constituicao;
    protected final String letra;
    protected final boolean fazParteDaSociedadeDoAnel;

    protected Personagem(int forca, int agilidade, int inteligencia, int constituicao, String letra, boolean fazParteDaSociedadeDoAnel) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
        this.letra = letra;
        this.fazParteDaSociedadeDoAnel = fazParteDaSociedadeDoAnel;
    }

    public int getForca() {
        return this.forca;
    }

    public int getAgilidade() {
        return this.agilidade;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }

    public int getConstituicao() {
        return this.constituicao;
    }

    public String getLetra() {
        return this.letra;
    }

    public boolean fazParteDaSociedadeDoAnel() {
        return this.fazParteDaSociedadeDoAnel;
    }

    public int getDirecaoDeslocamento() {
        return this.fazParteDaSociedadeDoAnel ? 1 : -1;
    }

    public void receberAtaque(int dano) {
        this.constituicao -= dano;
    }

    public boolean ehInimigo(Personagem personagem) {
        return this.fazParteDaSociedadeDoAnel ^ personagem.fazParteDaSociedadeDoAnel;
    }

    public boolean foiDestruido() {
        return this.constituicao <= 0;
    }

    public abstract void movimentar(Mapa mapa);

    public abstract void atacar(Mapa mapa);

    @Override
    public String toString() {
        if (this.constituicao <= 0) {
            return " ";
        }

        return this.letra;
    }
}
