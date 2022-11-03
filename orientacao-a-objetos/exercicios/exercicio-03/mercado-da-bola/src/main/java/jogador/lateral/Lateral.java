package jogador.lateral;

import clube.Clube;
import jogador.ApetiteFinanceiro;
import jogador.Jogador;

import java.math.BigDecimal;

public class Lateral extends Jogador {
    private static final double PERCENTUAL_ACRESCIMO = 0.02;
    private static final double PERCENTUAL_DESCONTO = 0.30;
    private static final int IDADE_MINIMA_DESCONTO = 28;

    private final int quantidadeCruzamentosCerteirosAno;

    public Lateral(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeCruzamentosCerteirosAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeCruzamentosCerteirosAno = quantidadeCruzamentosCerteirosAno;
    }

    @Override
    public BigDecimal calcularValorDeCompra() {
        BigDecimal valorDeCompraSemAcrescimo = super.calcularValorDeCompra();

        BigDecimal percentualAcrescimo = BigDecimal.valueOf(this.quantidadeCruzamentosCerteirosAno * PERCENTUAL_ACRESCIMO);
        BigDecimal valorDeCompraComAcrescimo = valorDeCompraSemAcrescimo.add(valorDeCompraSemAcrescimo.multiply(percentualAcrescimo));

        if (this.idade <= IDADE_MINIMA_DESCONTO) {
            return valorDeCompraComAcrescimo;
        }

        BigDecimal percentualDesconto = BigDecimal.valueOf(PERCENTUAL_DESCONTO);
        return valorDeCompraComAcrescimo.subtract(valorDeCompraComAcrescimo.multiply(percentualDesconto));
    }
}
