package personagem.orc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrcTest {
    @Test
    public void deveGrunir() {
        // Arrange
        Orc orc = new Orc();
        String grunhidoEsperado = "Arrrggghhh";

        // Act
        String grunhido = orc.grunir();

        // Assert
        assertEquals(grunhidoEsperado, grunhido);
    }
}