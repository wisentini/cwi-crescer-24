package personagem.boromir;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoromirTest {
    @Test
    public void deveFalarFraseEspecifica() {
        // Arrange
        Boromir boromir = new Boromir();
        String falaEsperada = "One does not simply walk into Mordor.";

        // Act
        String fala = boromir.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveEnvelhecer() {
        // Arrange
        Boromir boromir = new Boromir();
        int constituicaoEsperada = boromir.getConstituicao() - 2;

        // Act
        boromir.envelhecer();
        int constituicao = boromir.getConstituicao();

        // Assert
        assertEquals(constituicaoEsperada, constituicao);
    }
}