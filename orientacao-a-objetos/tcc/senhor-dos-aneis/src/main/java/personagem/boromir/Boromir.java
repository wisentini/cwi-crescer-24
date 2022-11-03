package personagem.boromir;

import personagem.classe.guerreiro.Guerreiro;
import personagem.comportamento.Fala;
import personagem.comportamento.raca.humano.Humano;

public class Boromir extends Guerreiro implements Humano, Fala {
    private static final int FORCA = 7;
    private static final int AGILIDADE = 6;
    private static final int INTELIGENCIA = 3;
    private static final int CONSTITUICAO_INICIAL = 40;
    private static final String LETRA = "B";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = true;

    public Boromir() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }

    @Override
    public void envelhecer() {
        this.constituicao -= 2;
    }
}
