package militar.elite;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EliteTest {
    @Test
    public void devePossuirLicencasValidasQuandoLicencasForemValidas() {
        // Arrange
        Elite piloto = new Elite(
            3000,
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20),
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
        Elite piloto = new Elite(
                3000,
                LocalDate.now().minusYears(1),
                LocalDate.now().minusYears(1),
                LocalDate.now().minusYears(1),
                LocalDate.now().minusYears(1)
        );

        // Act
        boolean possuiLicencasValidas = piloto.licencasValidas();

        // Assert
        assertFalse(possuiLicencasValidas);
    }
}
