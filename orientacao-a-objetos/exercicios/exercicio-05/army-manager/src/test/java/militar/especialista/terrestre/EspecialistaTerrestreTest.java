package militar.especialista.terrestre;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EspecialistaTerrestreTest {
    @Test
    public void devePossuirLicencasValidasQuandoLicencasForemValidas() {
        // Arrange
        EspecialistaTerrestre piloto = new EspecialistaTerrestre(
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
        EspecialistaTerrestre piloto = new EspecialistaTerrestre(
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
