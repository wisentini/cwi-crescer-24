package personagem.goblim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoblimTest {
    @Test
    public void deveGrunir() {
        // Arrange
        Goblim goblim = new Goblim();
        String grunhidoEsperado = "Iiisshhhh";

        // Act
        String grunhido = goblim.grunir();

        // Assert
        assertEquals(grunhidoEsperado, grunhido);
    }
}
