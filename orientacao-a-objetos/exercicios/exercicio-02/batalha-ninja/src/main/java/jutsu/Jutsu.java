package jutsu;

public class Jutsu {
    private static final int QTDE_MAX_CHAKRA = 5;
    private static final int DANO_MAX = 10;

    private final int quantidadeChakra;
    private final int dano;

    public Jutsu(int quantidadeChakra, int dano) {
        this.quantidadeChakra = Math.min(quantidadeChakra, QTDE_MAX_CHAKRA);
        this.dano = Math.min(dano, DANO_MAX);
    }

    public int getQuantidadeChakra() {
        return this.quantidadeChakra;
    }

    public int getDano() {
        return this.dano;
    }
}
