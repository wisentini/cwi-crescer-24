package militar.especialista.terrestre;

import militar.piloto.Piloto;
import militar.piloto.caminhao.IPilotoCaminhao;
import militar.piloto.tanque.IPilotoTanque;

import java.time.LocalDate;

public class EspecialistaTerrestre extends Piloto implements IPilotoCaminhao, IPilotoTanque {
    private final LocalDate dataValidadeLicencaPilotagemCaminhoes;
    private final LocalDate dataValidadeLicencaPilotagemTanques;

    public EspecialistaTerrestre(double salario, LocalDate dataValidadeLicencaPilotagemCaminhoes, LocalDate dataValidadeLicencaPilotagemTanques) {
        super(salario);
        this.dataValidadeLicencaPilotagemCaminhoes = dataValidadeLicencaPilotagemCaminhoes;
        this.dataValidadeLicencaPilotagemTanques = dataValidadeLicencaPilotagemTanques;
    }

    @Override
    public boolean licencaPilotagemCaminhoesValida() {
        return this.dataValidadeLicencaPilotagemCaminhoes.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencaPilotagemTanquesValida() {
        return this.dataValidadeLicencaPilotagemTanques.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencasValidas() {
        return this.licencaPilotagemCaminhoesValida() && this.licencaPilotagemTanquesValida();
    }
}
