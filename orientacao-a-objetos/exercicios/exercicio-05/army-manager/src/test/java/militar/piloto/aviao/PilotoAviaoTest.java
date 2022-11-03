package militar.piloto.aviao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PilotoAviaoTest {
    @Test
    public void devePossuirLicencasValidasQuandoLicencasForemValidas() {
        // Arrange
        PilotoAviaoImpl piloto = new PilotoAviaoImpl(2600, LocalDate.now().plusDays(20));

        // Act
        boolean possuiLicencasValidas = piloto.licencasValidas();

        // Assert
        assertTrue(possuiLicencasValidas);
    }

    @Test
    public void devePossuirLicencasInvalidasQuandoLicencasForemInvalidas() {
        // Arrange
        PilotoAviaoImpl piloto = new PilotoAviaoImpl(2600, LocalDate.now().minusYears(1));

        // Act
        boolean possuiLicencasValidas = piloto.licencasValidas();

        // Assert
        assertFalse(possuiLicencasValidas);
    }
}
