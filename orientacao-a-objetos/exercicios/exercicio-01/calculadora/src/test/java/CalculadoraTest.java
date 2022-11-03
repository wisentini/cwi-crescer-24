import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    @Test
    public void deveSomarCorretamenteQuandoOsValoresForemInteiros() {
        // Arrange
        double valorA = 2;
        double valorB = 2;
        double valorEsperado = 4;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoSoma = calculadora.somar(valorA, valorB);

        // Assert
        assertEquals(valorEsperado, resultadoSoma, 0.01);
    }

    @Test
    public void deveSubtrairCorretamenteQuandoOsValoresForemInteiros() {
        // Arrange
        double valorA = 15;
        double valorB = 7;
        double valorEsperado = 8;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoSubtracao = calculadora.subtrair(valorA, valorB);

        // Assert
        assertEquals(valorEsperado, resultadoSubtracao, 0.01);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosForemInteiros() {
        // Arrange
        double valorA = 16;
        double valorB = 5;
        double valorEsperado = 3.2;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoDivisao = calculadora.dividir(valorA, valorB);

        // Assert
        assertEquals(valorEsperado, resultadoDivisao, 0.01);
    }

    @Test
    public void deveMultiplicarCorretamenteQuandoNumerosForemInteiros() {
        // Arrange
        double valorA = 4;
        double valorB = 3;
        double valorEsperado = 12;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoMultiplicacao = calculadora.multiplicar(valorA, valorB);

        // Assert
        assertEquals(valorEsperado, resultadoMultiplicacao, 0.01);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosPossuemPontosFlutuantes() {
        // Arrange
        double valorA = 16.8;
        double valorB = 4.6;
        double valorEsperado = 3.65;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoDivisao = calculadora.dividir(valorA, valorB);

        // Assert
        assertEquals(valorEsperado, resultadoDivisao, 0.01);
    }

    @Test
    public void deveCalcularRaizQuadradaCorretamenteQuandoNumeroForInteiro() {
        // Arrange
        double valor = 16;
        double valorEsperado = 4;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoRaizQuadrada = calculadora.calcularRaizQuadrada(valor);

        // Assert
        assertEquals(valorEsperado, resultadoRaizQuadrada, 0.01);
    }

    @Test
    public void deveCalcularExponencialCorretamenteQuandoNumeroPossuiPontoFlutuante() {
        // Arrange
        double valor = 2.8;
        double valorEsperado = 16.44;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoExponencial = calculadora.calcularExponencial(valor);

        // Assert
        assertEquals(valorEsperado, resultadoExponencial, 0.01);
    }

    @Test
    public void deveCalcularPotenciaCorretamenteQuandoNumerosForemInteiros() {
        // Arrange
        double base = 4;
        double expoente = 3;
        double valorEsperado = 64;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoPotencia = calculadora.calcularPotencia(base, expoente);

        // Assert
        assertEquals(valorEsperado, resultadoPotencia, 0.01);
    }

    @Test
    public void deveCalcularSomaRaizesBhaskaraCorretamenteQuandoNumerosForemInteiros() {
        // Arrange
        double a = 1;
        double b = 2;
        double c = -15;
        double valorEsperado = -2;
        Calculadora calculadora = new Calculadora();

        // Act
        double resultadoSomaRaizesBhaskara = calculadora.calcularSomaRaizesBhaskara(a, b, c);

        // Assert
        assertEquals(valorEsperado, resultadoSomaRaizesBhaskara, 0.01);
    }
}
