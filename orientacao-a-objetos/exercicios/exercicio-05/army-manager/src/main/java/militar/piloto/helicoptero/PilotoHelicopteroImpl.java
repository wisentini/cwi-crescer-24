package militar.piloto.helicoptero;

import militar.piloto.Piloto;

import java.time.LocalDate;

public class PilotoHelicopteroImpl extends Piloto implements IPilotoHelicoptero {
    private final LocalDate dataValidadeLicencaPilotagemHelicopteros;

    public PilotoHelicopteroImpl(double salario, LocalDate dataValidadeLicencaPilotagemHelicopteros) {
        super(salario);
        this.dataValidadeLicencaPilotagemHelicopteros = dataValidadeLicencaPilotagemHelicopteros;
    }

    @Override
    public boolean licencaPilotagemHelicopterosValida() {
        return this.dataValidadeLicencaPilotagemHelicopteros.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencasValidas() {
        return this.licencaPilotagemHelicopterosValida();
    }
}
