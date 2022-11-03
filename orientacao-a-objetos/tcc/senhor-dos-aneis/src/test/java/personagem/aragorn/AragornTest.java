package personagem.aragorn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AragornTest {
    @Test
    public void deveFalarFraseEspecifica() {
        // Arrange
        Aragorn aragorn = new Aragorn();
        String falaEsperada = "A day may come when the courage of men fails… but it is not THIS day.";

        // Act
        String fala = aragorn.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveEnvelhecer() {
        // Arrange
        Aragorn aragorn = new Aragorn();
        int constituicaoEsperada = aragorn.getConstituicao() - 1;

        // Act
        aragorn.envelhecer();
        int constituicao = aragorn.getConstituicao();

        // Assert
        assertEquals(constituicaoEsperada, constituicao);
    }
}
