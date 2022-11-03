package simulacao;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.ar.EspecialistaDoAr;
import militar.piloto.tanque.PilotoTanqueImpl;

import veiculo.Veiculo;
import veiculo.aviao.Aviao;
import veiculo.tanque.Tanque;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SimulacaoTest {
    @Test
    public void deveCalcularOCustoTotalDaMissaoCorretamente() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(this.criarAviao());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());

        Simulacao simulacao = new Simulacao(1137, veiculos, 1);

        double custoTotal = simulacao.getCustoTotalMissao();

        assertEquals(213623.81, custoTotal, 0.1);
    }

    @Test
    public void deveCalcularOCustoTotalComCombustivelCorretamente() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(this.criarAviao());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());

        Simulacao simulacao = new Simulacao(1137, veiculos, 1);

        double gastoTotalCombustivel = simulacao.getGastoTotalCombustivel();

        assertEquals(170623.83, gastoTotalCombustivel, 0.1);
    }

    @Test
    public void deveCalcularOCustoToralComSalariosCorretamente() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(this.criarAviao());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());

        Simulacao simulacao = new Simulacao(1137, veiculos, 1);

        double gastoTotalSalario = simulacao.getGastoTotalSalario();

        assertEquals(43000, gastoTotalSalario, 0);
    }

    @Test
    public void deveCalcularOCustoTotalDaMissaoIncorretamente() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(this.criarAviao());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());

        Simulacao simulacao = new Simulacao(1137, veiculos, 1);

        double custoTotal = simulacao.getCustoTotalMissao();

        assertNotEquals(136238.1, custoTotal, 0.1);
    }

    @Test
    public void deveCalcularOCustoTotalComCombustivelIncorretamente() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(this.criarAviao());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());
        veiculos.add(this.criarTanque());

        Simulacao simulacao = new Simulacao(1137, veiculos, 1);

        double gastoTotalCombustivel = simulacao.getGastoTotalCombustivel();

        assertNotEquals(706238.31, gastoTotalCombustivel, 0.1);
    }

    private Tanque criarTanque() {
        Elite piloto = new Elite(
            3000,
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanqueImpl(2500, LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(600));
        tripulacao.add(new Militar(600));

        return new Tanque(piloto, tripulacao, 0.22, 3.46);
    }

    private Aviao criarAviao() {
        EspecialistaDoAr piloto = new EspecialistaDoAr(7000, LocalDate.now().plusDays(-20), LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        return new Aviao(piloto, tripulacao, 0.14, 10);
    }
}
