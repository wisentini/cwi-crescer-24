package personagem.gimli;

import personagem.classe.guerreiro.Guerreiro;
import personagem.comportamento.Fala;
import personagem.comportamento.raca.anao.Anao;

public class Gimli extends Guerreiro implements Anao, Fala {
    private static final int FORCA = 9;
    private static final int AGILIDADE = 2;
    private static final int INTELIGENCIA = 4;
    private static final int CONSTITUICAO_INICIAL = 60;
    private static final String LETRA = "I";
    private static final boolean FAZ_PARTE_DA_SOCIEDADE_DO_ANEL = true;

    private int numeroDeVezesQueBebeu;

    public Gimli() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL, LETRA, FAZ_PARTE_DA_SOCIEDADE_DO_ANEL);
        this.numeroDeVezesQueBebeu = 0;
    }

    public boolean taBebado() {
        return this.numeroDeVezesQueBebeu >= 3;
    }

    @Override
    public String falar() {
        if (this.taBebado()) {
            return "What did I say? He can't hold his liquor!";
        } else {
            return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        }
    }

    @Override
    public void beber() {
        this.numeroDeVezesQueBebeu++;
    }
}
