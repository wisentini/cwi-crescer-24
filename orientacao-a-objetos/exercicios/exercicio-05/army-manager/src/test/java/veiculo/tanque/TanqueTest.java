package veiculo.tanque;

import militar.Militar;
import militar.especialista.terrestre.EspecialistaTerrestre;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TanqueTest {
    @Test
    public void devePossuirTripulacaoValidaQuandoTripulacaoForValida() {
        // Arrange
        EspecialistaTerrestre piloto = new EspecialistaTerrestre(
                7000,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));

        Tanque tanque = new Tanque(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = tanque.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }

    @Test
    public void devePossuirTripulacaoInvalidaQuandoTripulacaoForInvalida() {
        // Arrange
        EspecialistaTerrestre piloto = new EspecialistaTerrestre(
                7000,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        Tanque tanque = new Tanque(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = tanque.tripulacaoValida();

        // Assert
        assertFalse(tripulacaoValida);
    }
}
