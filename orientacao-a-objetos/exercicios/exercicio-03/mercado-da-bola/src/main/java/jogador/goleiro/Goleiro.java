package jogador.goleiro;

import clube.Clube;
import jogador.ApetiteFinanceiro;
import jogador.Jogador;

import java.math.BigDecimal;

public class Goleiro extends Jogador {
    private static final double PERCENTUAL_ACRESCIMO_PENALTI_DEFENDIDO_ANO = 0.04;

    private final int quantidadePenaltisDefendidosAno;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadePenaltisDefendidosAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadePenaltisDefendidosAno = quantidadePenaltisDefendidosAno;
    }

    @Override
    public BigDecimal calcularValorDeCompra() {
        BigDecimal valorDeCompraSemAcrescimo = super.calcularValorDeCompra();

        BigDecimal percentualAcrescimo = BigDecimal.valueOf(this.quantidadePenaltisDefendidosAno * PERCENTUAL_ACRESCIMO_PENALTI_DEFENDIDO_ANO);
        return valorDeCompraSemAcrescimo.add(valorDeCompraSemAcrescimo.multiply(percentualAcrescimo));
    }
}
