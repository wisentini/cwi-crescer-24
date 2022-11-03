package personagem.goblim;

import personagem.classe.arqueiro.Arqueiro;
import personagem.comportamento.raca.monstro.Monstro;

public class Goblim extends Arqueiro implements Monstro {
    private static final int FORCA = 3;
    private static final int AGILIDADE = 6;
    private static final int INTELIGENCIA = 1;
    private static final int CONSTITUICAO_INICIAL = 20;
    private static final String LETRA = "M";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = false;

    public Goblim() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String grunir() {
        return "Iiisshhhh";
    }
}
