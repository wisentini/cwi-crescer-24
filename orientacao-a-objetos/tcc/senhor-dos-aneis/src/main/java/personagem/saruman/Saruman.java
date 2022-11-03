package personagem.saruman;

import personagem.classe.mago.Mago;
import personagem.comportamento.Fala;
import personagem.comportamento.raca.maia.Maia;

public class Saruman extends Mago implements Maia, Fala {
    private static final int FORCA = 2;
    private static final int AGILIDADE = 2;
    private static final int INTELIGENCIA = 9;
    private static final int CONSTITUICAO_INICIAL = 70;
    private static final String LETRA = "S";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = false;

    public Saruman() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }

    @Override
    public Saruman ressucitar() {
        return null;
    }
}
