package personagem.urukhai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrukhaiTest {
    @Test
    public void deveFalarFraseEspecifica() {
        // Arrange
        Urukhai urukhai = new Urukhai();
        String falaEsperada = "Looks like meat's back on the menu boys!";

        // Act
        String fala = urukhai.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveEnvelhecer() {
        // Arrange
        Urukhai urukhai = new Urukhai();
        int constituicaoEsperada = urukhai.getConstituicao() - 2;

        // Act
        urukhai.envelhecer();
        int constituicao = urukhai.getConstituicao();

        // Assert
        assertEquals(constituicaoEsperada, constituicao);
    }

    @Test
    public void deveGrunir() {
        // Arrange
        Urukhai urukhai = new Urukhai();
        String grunhidoEsperado = "Uuurrrrrr";

        // Act
        String grunhido = urukhai.grunir();

        // Assert
        assertEquals(grunhidoEsperado, grunhido);
    }
}
