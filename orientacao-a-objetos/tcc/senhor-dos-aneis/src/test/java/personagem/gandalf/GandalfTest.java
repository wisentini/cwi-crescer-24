package personagem.gandalf;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GandalfTest {
    @Test
    public void deveFalarFraseEspecifica() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        String falaEsperada = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

        // Act
        String fala = gandalf.falar();

        // Assert
        assertEquals(falaEsperada, fala);
    }

    @Test
    public void deveRetornarNovoObjetoSeConstituicaoForMenorOuIgualA0AoRessucitar() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        int dano = gandalf.getConstituicao();

        // Act
        gandalf.receberAtaque(dano);
        Gandalf novoGandalf = gandalf.ressucitar();

        // Assert
        assertNotNull(novoGandalf);
    }

    @Test
    public void deveRetornarNullSeConstituicaoForMaiorQue0AoRessucitar() {
        // Arrange
        Gandalf gandalf = new Gandalf();

        // Act
        Gandalf novoGandalf = gandalf.ressucitar();

        // Assert
        assertEquals(gandalf, novoGandalf);
    }
}
