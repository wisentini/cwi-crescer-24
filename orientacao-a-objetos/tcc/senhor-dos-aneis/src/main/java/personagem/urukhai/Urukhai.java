package personagem.urukhai;

import personagem.classe.guerreiro.Guerreiro;
import personagem.comportamento.Fala;
import personagem.comportamento.raca.humano.Humano;
import personagem.comportamento.raca.monstro.Monstro;

public class Urukhai extends Guerreiro implements Humano, Monstro, Fala {
    private static final int FORCA = 8;
    private static final int AGILIDADE = 6;
    private static final int INTELIGENCIA = 3;
    private static final int CONSTITUICAO_INICIAL = 45;
    private static final String LETRA = "U";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = false;

    public Urukhai() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public void envelhecer() {
        this.constituicao -= 2;
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }
}
