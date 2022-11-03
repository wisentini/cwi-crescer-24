package veiculo.caminhao;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.terrestre.EspecialistaTerrestre;
import militar.piloto.caminhao.PilotoCaminhaoImpl;
import veiculo.Veiculo;

import java.util.List;

public class Caminhao extends Veiculo {
    public Caminhao(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Caminhao(EspecialistaTerrestre piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Caminhao(PilotoCaminhaoImpl piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        return this.piloto.licencasValidas() && this.tripulacao.size() >= 5 && this.tripulacao.size() <= 30;
    }
}
