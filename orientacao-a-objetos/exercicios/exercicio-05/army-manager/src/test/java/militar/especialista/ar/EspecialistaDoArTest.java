package militar.especialista.ar;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EspecialistaDoArTest {
    @Test
    public void devePossuirLicencasValidasQuandoLicencasForemValidas() {
        // Arrange
        EspecialistaDoAr piloto = new EspecialistaDoAr(
                6541,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)
        );

        // Act
        boolean possuiLicencasValidas = piloto.licencasValidas();

        // Assert
        assertTrue(possuiLicencasValidas);
    }

    @Test
    public void devePossuirLicencasInvalidasQuandoLicencasForemInvalidas() {
        // Arrange
        EspecialistaDoAr piloto = new EspecialistaDoAr(
                6541,
                LocalDate.now().minusYears(1),
                LocalDate.now().minusYears(1)
        );

        // Act
        boolean possuiLicencasValidas = piloto.licencasValidas();

        // Assert
        assertFalse(possuiLicencasValidas);
    }
}
