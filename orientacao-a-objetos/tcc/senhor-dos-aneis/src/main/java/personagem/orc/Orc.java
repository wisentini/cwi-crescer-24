package personagem.orc;

import personagem.classe.guerreiro.Guerreiro;
import personagem.comportamento.raca.monstro.Monstro;

public class Orc extends Guerreiro implements Monstro {
    private static final int FORCA = 7;
    private static final int AGILIDADE = 4;
    private static final int INTELIGENCIA = 1;
    private static final int CONSTITUICAO_INICIAL = 30;
    private static final String LETRA = "O";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = false;

    public Orc() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String grunir() {
        return "Arrrggghhh";
    }
}
