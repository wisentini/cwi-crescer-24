package negociacao;

import clube.Clube;
import jogador.Jogador;

import java.math.BigDecimal;

public class Negociacao {
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse) {
        if (!jogadorDeInteresse.temInteresseEmSerTransferido(clubeInteressado)) {
            return false;
        }

        BigDecimal saldoAtualDisponivelEmCaixa = clubeInteressado.getSaldoDisponivelEmCaixa();
        BigDecimal valorDeCompraJogador = jogadorDeInteresse.calcularValorDeCompra();
        boolean saldoAtualDisponivelEmCaixaEhInsuficiente = saldoAtualDisponivelEmCaixa.compareTo(valorDeCompraJogador) < 0;

        if (saldoAtualDisponivelEmCaixaEhInsuficiente) {
            return false;
        }

        jogadorDeInteresse.transferir(clubeInteressado);

        BigDecimal novoSaldoDisponivelEmCaixa = saldoAtualDisponivelEmCaixa.subtract(valorDeCompraJogador);
        clubeInteressado.setSaldoDisponivelEmCaixa(novoSaldoDisponivelEmCaixa);

        return true;
    }
}
