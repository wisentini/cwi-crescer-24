package personagem.legolas;

import personagem.classe.arqueiro.Arqueiro;
import personagem.comportamento.Fala;
import personagem.comportamento.raca.elfo.Elfo;

public class Legolas extends Arqueiro implements Elfo, Fala {
    private static final int FORCA = 5;
    private static final int AGILIDADE = 10;
    private static final int INTELIGENCIA = 6;
    private static final int CONSTITUICAO_INICIAL = 80;
    private static final String LETRA = "L";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = true;

    public Legolas() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
    }

    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";
    }

    @Override
    public String falarElfico() {
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }
}
