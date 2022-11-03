package veiculo.tanque;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.terrestre.EspecialistaTerrestre;
import militar.piloto.tanque.PilotoTanqueImpl;
import veiculo.Veiculo;

import java.util.List;

public class Tanque extends Veiculo {
    public Tanque(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Tanque(EspecialistaTerrestre piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Tanque(PilotoTanqueImpl piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        return this.piloto.licencasValidas() && this.tripulacao.size() == 3;
    }
}
