package militar.piloto.aviao;

import militar.piloto.Piloto;

import java.time.LocalDate;

public class PilotoAviaoImpl extends Piloto implements IPilotoAviao {
    private final LocalDate dataValidadeLicencaPilotagemAvioes;

    public PilotoAviaoImpl(double salario, LocalDate dataValidadeLicencaPilotagemAvioes) {
        super(salario);
        this.dataValidadeLicencaPilotagemAvioes = dataValidadeLicencaPilotagemAvioes;
    }

    @Override
    public boolean licencaPilotagemAvioesValida() {
        return this.dataValidadeLicencaPilotagemAvioes.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencasValidas() {
        return this.licencaPilotagemAvioesValida();
    }
}
