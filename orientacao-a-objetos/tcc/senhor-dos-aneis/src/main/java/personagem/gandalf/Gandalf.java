package personagem.gandalf;

import personagem.classe.mago.Mago;
import personagem.comportamento.Fala;
import personagem.comportamento.raca.maia.Maia;

public class Gandalf extends Mago implements Maia, Fala {
    private static final int FORCA = 2;
    private static final int AGILIDADE = 3;
    private static final int INTELIGENCIA = 10;
    private static final int CONSTITUICAO_INICIAL = 80;
    private static final String LETRA = "G";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = true;

    public Gandalf() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    @Override
    public Gandalf ressucitar() {
        if (this.constituicao <= 0) {
            return new Gandalf();
        }

        return this;
    }
}
