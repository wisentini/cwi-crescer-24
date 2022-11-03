package ninja;

import jutsu.Jutsu;

public class Ninja {
    private static final int CHAKRA_INICIAL = 100;

    private final String nome;
    private int chakra;
    private final Jutsu jutsuPrincipal;

    public Ninja(String nome, Jutsu jutsuPrincipal) {
        this.nome = nome;
        this.chakra = CHAKRA_INICIAL;
        this.jutsuPrincipal = jutsuPrincipal;
    }

    public void receberGolpe(int dano) {
        this.chakra -= dano;
    }

    public void atacar(Ninja oponente) {
        int danoJutsuPrincipal = this.jutsuPrincipal.getDano();
        oponente.receberGolpe(danoJutsuPrincipal);

        int quantidadeChakraJutsuPrincipal = this.jutsuPrincipal.getQuantidadeChakra();
        this.chakra -= quantidadeChakraJutsuPrincipal;
    }

    public boolean ehOItachi() {
        return this.nome.equals("Itachi");
    }

    public int getChakra() {
        return this.chakra;
    }
}
