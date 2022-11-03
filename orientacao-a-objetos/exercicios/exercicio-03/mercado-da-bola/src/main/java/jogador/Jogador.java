package jogador;

import clube.Clube;

import java.math.BigDecimal;

public abstract class Jogador {
    protected static final int REPUTACAO_HISTORICA_MIN_CLUBE = 1;
    protected static final int REPUTACAO_HISTORICA_MIN = 0;
    protected static final int REPUTACAO_HISTORICA_MAX = 10;

    protected String nome;
    protected int idade;
    protected Clube clubeAtual;
    protected int reputacaoHistorica;
    protected ApetiteFinanceiro apetiteFinanceiro;
    protected BigDecimal preco;

    protected Jogador(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        this.reputacaoHistorica = reputacaoHistorica < REPUTACAO_HISTORICA_MIN ? REPUTACAO_HISTORICA_MIN : Math.min(reputacaoHistorica, REPUTACAO_HISTORICA_MAX);
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public String nomeClubeAtual() {
        if (this.clubeAtual != null) {
            return this.clubeAtual.getNome();
        }

        return "Sem Clube";
    }

    public boolean temInteresseEmSerTransferido(Clube clubeDestino) {
        return clubeDestino != null && clubeDestino.getReputacaoHistorica() >= REPUTACAO_HISTORICA_MIN_CLUBE;
    }

    public BigDecimal calcularValorDeCompra() {
        BigDecimal percentualApetiteFinanceiro = BigDecimal.valueOf(this.apetiteFinanceiro.getPercentual());
        return this.preco.add(this.preco.multiply(percentualApetiteFinanceiro));
    }

    public void transferir(Clube clube) {
        this.clubeAtual = clube;
    }
}
