package veiculo.aviao;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.ar.EspecialistaDoAr;
import militar.piloto.aviao.PilotoAviaoImpl;
import veiculo.Veiculo;

import java.util.List;

public class Aviao extends Veiculo {
    public Aviao(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Aviao(EspecialistaDoAr piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public Aviao(PilotoAviaoImpl piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        return this.piloto.licencasValidas() && this.tripulacao.size() <= 1;
    }
}
