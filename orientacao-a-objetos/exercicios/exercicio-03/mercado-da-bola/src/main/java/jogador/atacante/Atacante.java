package jogador.atacante;

import clube.Clube;
import jogador.ApetiteFinanceiro;
import jogador.Jogador;

import java.math.BigDecimal;

public class Atacante extends Jogador {
    private static final double PERCENTUAL_ACRESCIMO = 0.01;
    private static final double PERCENTUAL_DESCONTO = 0.25;
    private static final int IDADE_MINIMA_DESCONTO = 30;

    private final int quantidadeGolsAno;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeGolsAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeGolsAno = quantidadeGolsAno;
    }

    @Override
    public boolean temInteresseEmSerTransferido(Clube clubeDestino) {
        boolean temInteressePadrao = super.temInteresseEmSerTransferido(clubeDestino);
        boolean reputacaoHistoricaClubeDestinoEhMaior = clubeDestino.getReputacaoHistorica() > this.reputacaoHistorica;

        return temInteressePadrao && reputacaoHistoricaClubeDestinoEhMaior;
    }

    @Override
    public BigDecimal calcularValorDeCompra() {
        BigDecimal valorDeCompraSemAcrescimo = super.calcularValorDeCompra();

        BigDecimal percentualAcrescimo = BigDecimal.valueOf(this.quantidadeGolsAno * PERCENTUAL_ACRESCIMO);
        BigDecimal valorDeCompraComAcrescimo = valorDeCompraSemAcrescimo.add(valorDeCompraSemAcrescimo.multiply(percentualAcrescimo));

        if (this.idade <= IDADE_MINIMA_DESCONTO) {
            return valorDeCompraComAcrescimo;
        }

        BigDecimal percentualDesconto = BigDecimal.valueOf(PERCENTUAL_DESCONTO);
        return valorDeCompraComAcrescimo.subtract(valorDeCompraComAcrescimo.multiply(percentualDesconto));
    }
}
