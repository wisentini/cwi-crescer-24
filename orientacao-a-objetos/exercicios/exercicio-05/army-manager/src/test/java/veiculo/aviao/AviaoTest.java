package veiculo.aviao;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.ar.EspecialistaDoAr;
import militar.piloto.aviao.PilotoAviaoImpl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AviaoTest {
    @Test
    public void devePossuirTripulacaoValidaQuandoTripulacaoForValida() {
        // Arrange
        EspecialistaDoAr piloto = new EspecialistaDoAr(
            7000,
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        Aviao aviao = new Aviao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = aviao.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }

    @Test
    public void devePossuirTripulacaoInvalidaQuandoTripulacaoForInvalida() {
        // Arrange
        EspecialistaDoAr piloto = new EspecialistaDoAr(
                7000,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));

        Aviao aviao = new Aviao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = aviao.tripulacaoValida();

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

        Aviao aviao = new Aviao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = aviao.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }

    @Test
    public void deveTerTripulacaoValidaComPilotoAviaoComLicencasValidas() {
        PilotoAviaoImpl piloto = new PilotoAviaoImpl(
                8000,
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        Aviao aviao = new Aviao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = aviao.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }
}
