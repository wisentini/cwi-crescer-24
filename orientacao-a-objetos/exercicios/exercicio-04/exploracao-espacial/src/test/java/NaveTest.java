import nave.Nave;
import planeta.Planeta;
import planeta.PrioridadeExploracao;
import recurso.Recurso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NaveTest {
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        // Arrange
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, new ArrayList<>());
        int posicaoEsperada = 3;

        // Act
        milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();

        // Assert
        assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        // Arrange
        Planeta tatooine = new Planeta(6, new ArrayList<>());
        int valorTotalEsperado = 0;

        // Act
        int valorTotal = tatooine.getValorTotal();

        // Assert
        assertEquals(valorTotalEsperado, valorTotal);
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        // Arrange
        List<Recurso> recursos = Arrays.asList(Recurso.AGUA, Recurso.SILICIO, Recurso.FERRO);
        Planeta tatooine = new Planeta(6, recursos);
        int valorTotalEsperado = 270;

        // Act
        int valorTotal = tatooine.getValorTotal();

        // Assert
        assertEquals(valorTotalEsperado, valorTotal);
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        // Arrange
        Planeta tatooine = new Planeta(6, new ArrayList<>());
        int valorTotalPorPesoEsperado = 0;

        // Act
        double valorTotalPorPeso = tatooine.getValorTotalPorPeso();

        // Assert
        assertEquals(valorTotalPorPesoEsperado, valorTotalPorPeso, 0);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        // Arrange
        List<Recurso> recursos = Arrays.asList(Recurso.AGUA, Recurso.SILICIO, Recurso.FERRO);
        Planeta tatooine = new Planeta(6, recursos);
        double valorTotalPorPesoEsperado = 22.6875;

        // Act
        double valorTotalPorPeso = tatooine.getValorTotalPorPeso();

        // Assert
        assertEquals(valorTotalPorPesoEsperado, valorTotalPorPeso, 0);
    }

    @Test
    public void deveSobrarMaisCombustivelAoExplorarPorPosicao() {
        // Arrange
        List<Recurso> recursosPlanetaA = Arrays.asList(Recurso.SILICIO, Recurso.OURO);
        Planeta planetaA = new Planeta(3, recursosPlanetaA);

        List<Recurso> recursosPlanetaB = Collections.singletonList(Recurso.FERRO);
        Planeta planetaB = new Planeta(6, recursosPlanetaB);

        List<Recurso> recursosPlanetaC = Arrays.asList(Recurso.AGUA, Recurso.OXIGENIO, Recurso.FERRO);
        Planeta planetaC = new Planeta(9, recursosPlanetaC);

        List<Planeta> planetas = Arrays.asList(planetaA, planetaB, planetaC);

        Nave naveExploracaoPorPosicao = new Nave(100);
        Nave naveExploracaoPorValorTotal = new Nave(100);

        // Act
        naveExploracaoPorPosicao.explorar(planetas, PrioridadeExploracao.POSICAO);
        int quantidadeCombustivelExploracaoPorPosicao = naveExploracaoPorPosicao.getQuantidadeDeCombustivel();

        naveExploracaoPorValorTotal.explorar(planetas, PrioridadeExploracao.VALOR_TOTAL);
        int quantidadeCombustivelExploracaoPorValorTotal = naveExploracaoPorValorTotal.getQuantidadeDeCombustivel();

        boolean exploracaoPorPosicaoEhMaisEficiente = quantidadeCombustivelExploracaoPorPosicao > quantidadeCombustivelExploracaoPorValorTotal;

        // Assert
        assertTrue(exploracaoPorPosicaoEhMaisEficiente);
    }
}
