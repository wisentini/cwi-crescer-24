package personagem.gimli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GimliTest {
    @Test
    public void deveFalarFraseEspecificaQuandoEstiverSobrio() {
        // Arrange
        Gimli gimli = new Gimli();
        String falaEsperada = "Let them come. There is one Dwarf yet in Moria who still draws breath.";

        // Act
        String fala = gimli.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveFalarFraseEspecificaQuandoEstiverBebado() {
        // Arrange
        Gimli gimli = new Gimli();

        for (int i = 0; i < 3; i++) {
            gimli.beber();
        }

        String falaEsperada = "What did I say? He can't hold his liquor!";

        // Act
        String fala = gimli.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveFicarBebadoAoBeber3OuMaisVezes() {
        // Arrange
        Gimli gimli = new Gimli();

        for (int i = 0; i < 3; i++) {
            gimli.beber();
        }

        // Act
        for (int i = 0; i < 3; i++) {
            gimli.beber();
        }

        boolean taBebado = gimli.taBebado();

        // Assert
        assertTrue(taBebado);
    }

    @Test
    public void deveFicarSobrioAoBeberMenosQue3Vezes() {
        // Arrange
        Gimli gimli = new Gimli();
        gimli.beber();

        // Act
        boolean taBebado = gimli.taBebado();

        // Assert
        assertFalse(taBebado);
    }
}
