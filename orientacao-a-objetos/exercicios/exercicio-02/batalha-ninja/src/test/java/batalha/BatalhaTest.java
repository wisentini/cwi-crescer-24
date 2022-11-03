package batalha;

import jutsu.Jutsu;
import ninja.Ninja;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class BatalhaTest {
    @Test
    public void deveRetornarNinjaComJutsuMaisForteSeOsDoisGastamOMesmoChakra() {
        // Arrange
        Jutsu jutsuNinjaA = new Jutsu(5, 10);
        Ninja ninjaA = new Ninja("Naruto", jutsuNinjaA);

        Jutsu jutsuNinjaB = new Jutsu(5, 8);
        Ninja ninjaB = new Ninja("Gaara", jutsuNinjaB);

        // Act
        Ninja ninjaVencedor = Batalha.lutar(ninjaA, ninjaB);

        // Assert
        assertSame(ninjaA, ninjaVencedor);
    }

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {
        // Arrange
        Jutsu jutsuNinjaA = new Jutsu(5, 10);
        Ninja ninjaA = new Ninja("Naruto", jutsuNinjaA);

        Jutsu jutsuNinjaB = new Jutsu(5, 8);
        Ninja ninjaB = new Ninja("Gaara", jutsuNinjaB);

        int nivelChakraEsperado = 90;

        // Act
        ninjaA.atacar(ninjaB);

        // Assert
        assertEquals(nivelChakraEsperado, ninjaB.getChakra());
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoONomeForItachi() {
        // Arrange
        Jutsu jutsuNinjaA = new Jutsu(5, 8);
        Ninja ninjaA = new Ninja("Itachi", jutsuNinjaA);

        Jutsu jutsuNinjaB = new Jutsu(5, 10);
        Ninja ninjaB = new Ninja("Naruto", jutsuNinjaB);

        // Act
        Ninja ninjaVencedor = Batalha.lutar(ninjaA, ninjaB);

        // Assert
        assertSame(ninjaA, ninjaVencedor);
    }

    @Test
    public void deveRetornarSegundoNinjaComoVencedorQuandoONomeForItachi() {
        // Arrange
        Jutsu jutsuNinjaA = new Jutsu(5, 10);
        Ninja ninjaA = new Ninja("Naruto", jutsuNinjaA);

        Jutsu jutsuNinjaB = new Jutsu(5, 8);
        Ninja ninjaB = new Ninja("Itachi", jutsuNinjaB);

        // Act
        Ninja ninjaVencedor = Batalha.lutar(ninjaA, ninjaB);

        // Assert
        assertSame(ninjaB, ninjaVencedor);
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoEmpatar() {
        // Arrange
        Jutsu jutsuNinjaA = new Jutsu(5, 8);
        Ninja ninjaA = new Ninja("Gaara", jutsuNinjaA);

        Jutsu jutsuNinjaB = new Jutsu(5, 8);
        Ninja ninjaB = new Ninja("Naruto", jutsuNinjaB);

        // Act
        Ninja ninjaVencedor = Batalha.lutar(ninjaA, ninjaB);

        // Assert
        assertSame(ninjaA, ninjaVencedor);
    }
}
