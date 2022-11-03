package militar.piloto.caminhao;

import militar.piloto.Piloto;

import java.time.LocalDate;

public class PilotoCaminhaoImpl extends Piloto implements IPilotoCaminhao {
    private final LocalDate dataValidadeLicencaPilotagemCaminhoes;

    public PilotoCaminhaoImpl(double salario, LocalDate dataValidadeLicencaPilotagemCaminhoes) {
        super(salario);
        this.dataValidadeLicencaPilotagemCaminhoes = dataValidadeLicencaPilotagemCaminhoes;
    }

    @Override
    public boolean licencaPilotagemCaminhoesValida() {
        return this.dataValidadeLicencaPilotagemCaminhoes.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencasValidas() {
        return this.licencaPilotagemCaminhoesValida();
    }
}
