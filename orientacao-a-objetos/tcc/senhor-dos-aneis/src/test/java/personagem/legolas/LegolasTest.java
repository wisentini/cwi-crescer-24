package personagem.legolas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LegolasTest {
    @Test
    public void deveFalarFraseEspecifica() {
        // Arrange
        Legolas legolas = new Legolas();
        String falaEsperada = "They're taking the Hobbits to Isengard!";

        // Act
        String fala = legolas.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveFalarElfico() {
        // Arrange
        Legolas legolas = new Legolas();
        String falaElficaEsperada = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

        // Act
        String falaElfica = legolas.falarElfico();

        // Assert
        assertEquals(falaElficaEsperada, falaElfica);
    }
}
