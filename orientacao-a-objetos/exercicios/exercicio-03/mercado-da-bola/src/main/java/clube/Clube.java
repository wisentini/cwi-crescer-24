package clube;

import java.math.BigDecimal;

public class Clube {
    private String nome;
    private int reputacaoHistorica;
    private BigDecimal saldoDisponivelEmCaixa;

    public Clube(String nome, int reputacaoHistorica, BigDecimal saldoDisponivelEmCaixa) {
        this.nome = nome;
        this.reputacaoHistorica = reputacaoHistorica;
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }

    public String getNome() {
        return this.nome;
    }

    public int getReputacaoHistorica() {
        return this.reputacaoHistorica;
    }

    public BigDecimal getSaldoDisponivelEmCaixa() {
        return this.saldoDisponivelEmCaixa;
    }

    public void setSaldoDisponivelEmCaixa(BigDecimal saldoDisponivelEmCaixa) {
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }
}
