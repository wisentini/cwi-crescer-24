import clube.Clube;
import jogador.ApetiteFinanceiro;
import jogador.atacante.Atacante;
import jogador.goleiro.Goleiro;
import jogador.lateral.Lateral;
import jogador.meiocampo.MeioCampo;
import jogador.zagueiro.Zagueiro;
import negociacao.Negociacao;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegociacaoTest {
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(100000000));
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(800500), 12);

        // Act
        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        // Assert
        assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(800500), 20);

        // Act
        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        // Assert
        assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Barcelona", 10, BigDecimal.valueOf(1000000));
        Atacante atacante = new Atacante("Neymar", 30, null, 8, ApetiteFinanceiro.MERCENARIO, BigDecimal.valueOf(14056410), 32);

        // Act
        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        // Assert
        assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        // Arrange
        MeioCampo meioCampo = new MeioCampo("Mbappé", 23, null, 8, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(14056410));
        BigDecimal valorDeCompraEsperado = BigDecimal.valueOf(19678974);

        // Act
        BigDecimal valorDeCompra = meioCampo.calcularValorDeCompra();

        // Assert
        boolean valorDeCompraEstaCorreto = valorDeCompraEsperado.compareTo(valorDeCompra) == 0;
        assertTrue(valorDeCompraEstaCorreto);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        // Arrange
        MeioCampo meioCampo = new MeioCampo("Kross", 32, null, 8, ApetiteFinanceiro.MERCENARIO, BigDecimal.valueOf(25000000));
        BigDecimal valorDeCompraEsperado = BigDecimal.valueOf(31500000);

        // Act
        BigDecimal valorDeCompra = meioCampo.calcularValorDeCompra();

        // Assert
        boolean valorDeCompraEstaCorreto = valorDeCompraEsperado.compareTo(valorDeCompra) == 0;
        assertTrue(valorDeCompraEstaCorreto);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoGoleiro() {
        // Arrange
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(800500), 12);
        BigDecimal valorDeCompraEsperado = BigDecimal.valueOf(1184740);

        // Act
        BigDecimal valorDeCompra = goleiro.calcularValorDeCompra();

        // Assert
        boolean valorDeCompraEstaCorreto = valorDeCompraEsperado.compareTo(valorDeCompra) == 0;
        assertTrue(valorDeCompraEstaCorreto);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoZagueiro() {
        // Arrange
        Zagueiro zagueiro = new Zagueiro("Geromel", 36, null, 7, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(800500));
        BigDecimal valorDeCompraEsperado = BigDecimal.valueOf(640400);

        // Act
        BigDecimal valorDeCompra = zagueiro.calcularValorDeCompra();

        // Assert
        boolean valorDeCompraEstaCorreto = valorDeCompraEsperado.compareTo(valorDeCompra) == 0;
        assertTrue(valorDeCompraEstaCorreto);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoLateral() {
        // Arrange
        Lateral lateral = new Lateral("Kannemann", 31, null, 6, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(800500), 21);
        BigDecimal valorDeCompraEsperado = BigDecimal.valueOf(795697);

        // Act
        BigDecimal valorDeCompra = lateral.calcularValorDeCompra();

        // Assert
        boolean valorDeCompraEstaCorreto = valorDeCompraEsperado.compareTo(valorDeCompra) == 0;
        assertTrue(valorDeCompraEstaCorreto);
    }
}
