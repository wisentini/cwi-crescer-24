package veiculo.helicoptero;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.ar.EspecialistaDoAr;
import militar.piloto.helicoptero.PilotoHelicopteroImpl;
import veiculo.Veiculo;

import java.util.List;

public class Helicoptero extends Veiculo {
    public Helicoptero(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Helicoptero(EspecialistaDoAr piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Helicoptero(PilotoHelicopteroImpl piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        return this.piloto.licencasValidas() && this.tripulacao.size() <= 10;
    }
}
