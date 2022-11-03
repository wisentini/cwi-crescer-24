package militar.piloto.tanque;

import militar.piloto.Piloto;

import java.time.LocalDate;

public class PilotoTanqueImpl extends Piloto implements IPilotoTanque {
    private final LocalDate dataValidadeLicencaPilotagemTanques;

    public PilotoTanqueImpl(double salario, LocalDate dataValidadeLicencaPilotagemTanques) {
        super(salario);
        this.dataValidadeLicencaPilotagemTanques = dataValidadeLicencaPilotagemTanques;
    }

    @Override
    public boolean licencaPilotagemTanquesValida() {
        return this.dataValidadeLicencaPilotagemTanques.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencasValidas() {
        return this.licencaPilotagemTanquesValida();
    }
}
