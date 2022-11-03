package personagem.aragorn;

import personagem.classe.guerreiro.Guerreiro;
import personagem.comportamento.Fala;
import personagem.comportamento.raca.humano.Humano;

public class Aragorn extends Guerreiro implements Humano, Fala {
    private static final int FORCA = 10;
    private static final int AGILIDADE = 7;
    private static final int INTELIGENCIA = 6;
    private static final int CONSTITUICAO_INICIAL = 60;
    private static final String LETRA = "A";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = true;

    public Aragorn() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

    @Override
    public void envelhecer() {
        this.constituicao--;
    }
}
