package veiculo;

import militar.Militar;
import militar.piloto.Piloto;

import java.util.List;

public abstract class Veiculo {
    protected Piloto piloto;
    protected List<Militar> tripulacao;
    protected double quilometragemPorLitro;
    protected double precoPorLitroCombustivel;

    protected Veiculo(Piloto piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        this.piloto = piloto;
        this.tripulacao = tripulacao;
        this.quilometragemPorLitro = quilometragemPorLitro;
        this.precoPorLitroCombustivel = precoPorLitroCombustivel;
    }

    public abstract boolean tripulacaoValida();

    public double getGastoCombustivel(int distancia) {
        return distancia / this.quilometragemPorLitro * this.precoPorLitroCombustivel;
    }

    public Piloto getPiloto() {
        return this.piloto;
    }

    public List<Militar> getTripulacao() {
        return this.tripulacao;
    }
}
