package personagem.saruman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SarumanTest {
    @Test
    public void deveFalarFraseEspecifica() {
        // Arrange
        Saruman saruman = new Saruman();
        String falaEsperada = "Against the power of Mordor there can be no victory.";

        // Act
        String fala = saruman.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveRetornarNullAoRessucitar() {
        // Arrange
        Saruman saruman = new Saruman();

        // Act
        Saruman novoSaruman = saruman.ressucitar();

        // Assert
        assertNull(novoSaruman);
    }
}
