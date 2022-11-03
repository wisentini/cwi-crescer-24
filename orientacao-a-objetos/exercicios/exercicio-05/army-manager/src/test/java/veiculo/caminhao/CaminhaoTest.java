package veiculo.caminhao;

import militar.Militar;
import militar.elite.Elite;
import militar.especialista.terrestre.EspecialistaTerrestre;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminhaoTest {
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
        tripulacao.add(new Militar(2500));
        tripulacao.add(new Militar(2500));

        Caminhao caminhao = new Caminhao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = caminhao.tripulacaoValida();

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

        Caminhao caminhao = new Caminhao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = caminhao.tripulacaoValida();

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

        Caminhao caminhao = new Caminhao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean tripulacaoValida = caminhao.tripulacaoValida();

        // Assert
        assertTrue(tripulacaoValida);
    }
}
