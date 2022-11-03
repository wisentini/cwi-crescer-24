package simulacao;

import militar.Militar;
import veiculo.Veiculo;

import java.util.List;

public class Simulacao {
    private final int distanciaViagem;
    private final List<Veiculo> veiculos;
    private final int duracao;

    public Simulacao(int distanciaViagem, List<Veiculo> veiculos, int duracao) {
        this.distanciaViagem = distanciaViagem;
        this.veiculos = veiculos;
        this.duracao = duracao;
    }

    public double getGastoTotalCombustivel() {
        double gastoTotalCombustivel = 0;

        for (Veiculo veiculo : this.veiculos) {
            gastoTotalCombustivel += veiculo.getGastoCombustivel(this.distanciaViagem);
        }

        return gastoTotalCombustivel;
    }

    public double getGastoTotalSalario() {
        double gastoTotalSalario = 0;

        for (Veiculo veiculo : this.veiculos) {
            gastoTotalSalario += veiculo.getPiloto().getSalario();

            for (Militar militar : veiculo.getTripulacao()) {
                gastoTotalSalario += militar.getSalario();
            }
        }

        return gastoTotalSalario;
    }

    public double getCustoTotalMissao() {
        double gastoTotalCombustivel = this.getGastoTotalCombustivel();
        double gastoTotalSalario = this.getGastoTotalSalario();
        return gastoTotalSalario * this.duracao + gastoTotalCombustivel;
    }

    public boolean todasTripulacoesValidas() {
        for (Veiculo veiculo : this.veiculos) {
            if (!veiculo.tripulacaoValida()) {
                return false;
            }
        }

        return true;
    }
}
