package militar.especialista.ar;

import militar.piloto.Piloto;
import militar.piloto.aviao.IPilotoAviao;
import militar.piloto.helicoptero.IPilotoHelicoptero;

import java.time.LocalDate;

public class EspecialistaDoAr extends Piloto implements IPilotoAviao, IPilotoHelicoptero {
    private final LocalDate dataValidadeLicencaPilotagemAvioes;
    private final LocalDate dataValidadeLicencaPilotagemHelicopteros;

    public EspecialistaDoAr(double salario, LocalDate dataValidadeLicencaPilotagemAvioes, LocalDate dataValidadeLicencaPilotagemHelicopteros) {
        super(salario);
        this.dataValidadeLicencaPilotagemAvioes = dataValidadeLicencaPilotagemAvioes;
        this.dataValidadeLicencaPilotagemHelicopteros = dataValidadeLicencaPilotagemHelicopteros;
    }

    @Override
    public boolean licencaPilotagemAvioesValida() {
        return this.dataValidadeLicencaPilotagemAvioes.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencaPilotagemHelicopterosValida() {
        return this.dataValidadeLicencaPilotagemHelicopteros.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencasValidas() {
        return this.licencaPilotagemAvioesValida() && this.licencaPilotagemHelicopterosValida();
    }
}
