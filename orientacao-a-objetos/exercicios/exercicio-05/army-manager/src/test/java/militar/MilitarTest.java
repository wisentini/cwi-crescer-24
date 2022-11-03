package militar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MilitarTest {
    @Test
    public void devePossuirSalarioQuandoSalarioForInformado() {
        // Arrange
        double salarioEsperado = 1900;
        Militar militar = new Militar(salarioEsperado);

        // Act
        double salario = militar.getSalario();

        // Assert
        assertEquals(salarioEsperado, salario, 0);
    }
}
