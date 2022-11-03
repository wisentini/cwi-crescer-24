package militar.piloto;

import militar.Militar;

public abstract class Piloto extends Militar {
    protected Piloto(double salario) {
        super(salario);
    }

    public abstract boolean licencasValidas();
}
