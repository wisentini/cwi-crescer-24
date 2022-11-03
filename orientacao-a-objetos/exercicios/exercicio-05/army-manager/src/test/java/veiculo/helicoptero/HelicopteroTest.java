package veiculo.helicoptero;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.ar.EspecialistaDoAr;
import militar.piloto.helicoptero.PilotoHelicopteroImpl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelicopteroTest {
    @Test
    public void devePossuirTripulacaoValidaQuandoTripulacaoForValida() {
        // Arrange
        EspecialistaDoAr piloto = new EspecialistaDoAr(
                6000,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));

        Helicoptero helicoptero = new Helicoptero(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = helicoptero.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }

    @Test
    public void devePossuirTripulacaoInvalidaQuandoTripulacaoForInvalida() {
        // Arrange
        EspecialistaDoAr piloto = new EspecialistaDoAr(
                6000,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));

        Helicoptero helicoptero = new Helicoptero(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = helicoptero.tripulacaoValida();

        // Assert
        assertFalse(tripulacaoValida);
    }

    @Test
    public void deveTerTripulacaoValidaComPilotoEliteComLicencasValidas() {
        Elite piloto = new Elite(
            8000,
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));

        Helicoptero helicoptero = new Helicoptero(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = helicoptero.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }

    @Test
    public void deveTerTripulacaoValidaComPilotoHelicopteroComLicencasValidas() {
        PilotoHelicopteroImpl piloto = new PilotoHelicopteroImpl(
                8000,
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));

        Helicoptero helicoptero = new Helicoptero(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = helicoptero.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }
}
