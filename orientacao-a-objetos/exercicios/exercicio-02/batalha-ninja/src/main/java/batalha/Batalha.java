package batalha;

import ninja.Ninja;

public class Batalha {
    private static final int QTDE_ATAQUES_POR_NINJA = 3;

    private Batalha() {}

    public static Ninja lutar(Ninja ninjaA, Ninja ninjaB) {
        for (int i = 0; i < QTDE_ATAQUES_POR_NINJA; i++) {
            ninjaA.atacar(ninjaB);
            ninjaB.atacar(ninjaA);
        }

        if (ninjaA.ehOItachi()) {
            return ninjaA;
        }

        if (ninjaB.ehOItachi()) {
            return ninjaB;
        }

        if (ninjaA.getChakra() >= ninjaB.getChakra()) {
            return ninjaA;
        }

        return ninjaB;
    }
}
