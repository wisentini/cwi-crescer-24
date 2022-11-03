package militar.elite;

import militar.piloto.Piloto;
import militar.piloto.aviao.IPilotoAviao;
import militar.piloto.caminhao.IPilotoCaminhao;
import militar.piloto.helicoptero.IPilotoHelicoptero;
import militar.piloto.tanque.IPilotoTanque;

import java.time.LocalDate;

public class Elite extends Piloto implements IPilotoAviao, IPilotoHelicoptero, IPilotoCaminhao, IPilotoTanque {
    private final LocalDate dataValidadeLicencaPilotagemAvioes;
    private final LocalDate dataValidadeLicencaPilotagemHelicopteros;
    private final LocalDate dataValidadeLicencaPilotagemCaminhoes;
    private final LocalDate dataValidadeLicencaPilotagemTanques;

    public Elite(double salario, LocalDate dataValidadeLicencaPilotagemAvioes, LocalDate dataValidadeLicencaPilotagemHelicopteros, LocalDate dataValidadeLicencaPilotagemCaminhoes, LocalDate dataValidadeLicencaPilotagemTanques) {
        super(salario);
        this.dataValidadeLicencaPilotagemAvioes = dataValidadeLicencaPilotagemAvioes;
        this.dataValidadeLicencaPilotagemHelicopteros = dataValidadeLicencaPilotagemHelicopteros;
        this.dataValidadeLicencaPilotagemCaminhoes = dataValidadeLicencaPilotagemCaminhoes;
        this.dataValidadeLicencaPilotagemTanques = dataValidadeLicencaPilotagemTanques;
    }

    @Override
    public boolean licencasValidas() {
        return this.licencaPilotagemAvioesValida()       &&
               this.licencaPilotagemHelicopterosValida() &&
               this.licencaPilotagemCaminhoesValida()    &&
               this.licencaPilotagemTanquesValida();
    }

    @Override
    public boolean licencaPilotagemAvioesValida() {
        return this.dataValidadeLicencaPilotagemAvioes.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencaPilotagemCaminhoesValida() {
        return this.dataValidadeLicencaPilotagemCaminhoes.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencaPilotagemHelicopterosValida() {
        return this.dataValidadeLicencaPilotagemHelicopteros.isAfter(LocalDate.now());
    }

    @Override
    public boolean licencaPilotagemTanquesValida() {
        return this.dataValidadeLicencaPilotagemTanques.isAfter(LocalDate.now());
    }
}
