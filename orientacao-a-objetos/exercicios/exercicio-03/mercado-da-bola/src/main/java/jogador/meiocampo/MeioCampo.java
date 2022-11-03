package jogador.meiocampo;

import clube.Clube;
import jogador.ApetiteFinanceiro;
import jogador.Jogador;

import java.math.BigDecimal;

public class MeioCampo extends Jogador {
    private static final double PERCENTUAL_DESCONTO = 0.3;
    private static final int IDADE_MINIMA_DESCONTO = 30;

    public MeioCampo(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public boolean temInteresseEmSerTransferido(Clube clubeDestino) {
        boolean temInteressePadrao = super.temInteresseEmSerTransferido(clubeDestino);
        int diferencaReputacaoHistorica = this.reputacaoHistorica - clubeDestino.getReputacaoHistorica();

        return temInteressePadrao && diferencaReputacaoHistorica >= 2;
    }

    @Override
    public BigDecimal calcularValorDeCompra() {
        BigDecimal valorDeCompraSemDesconto = super.calcularValorDeCompra();

        if (this.idade <= IDADE_MINIMA_DESCONTO) {
            return valorDeCompraSemDesconto;
        }

        BigDecimal percentualDesconto = BigDecimal.valueOf(PERCENTUAL_DESCONTO);
        return valorDeCompraSemDesconto.subtract(valorDeCompraSemDesconto.multiply(percentualDesconto));
    }
}
