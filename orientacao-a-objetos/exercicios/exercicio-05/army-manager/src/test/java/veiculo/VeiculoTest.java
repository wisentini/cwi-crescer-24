package veiculo;

import militar.Militar;
import militar.especialista.ar.EspecialistaDoAr;
import militar.piloto.caminhao.PilotoCaminhaoImpl;
import militar.piloto.tanque.PilotoTanqueImpl;

import veiculo.aviao.Aviao;
import veiculo.caminhao.Caminhao;
import veiculo.tanque.Tanque;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {
    @Test
    public void deveCalcularCorretamentoGastoCombustivel() {
        // Arrange
        EspecialistaDoAr piloto = new EspecialistaDoAr(
                7000,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        Aviao aviao = new Aviao(piloto, tripulacao, 0.14, 10);

        double gastoCombustivelEsperado = 101928.57;

        // Act
        double gastoCombustivel = aviao.getGastoCombustivel(1427);

        // Assert
        assertEquals(gastoCombustivelEsperado, gastoCombustivel, 0.01);
    }

    @Test
    public void devePossuirPilotoComLicencasValidasQuandoPilotoPossuirLicencasValidas() {
        // Arrange
        PilotoCaminhaoImpl piloto = new PilotoCaminhaoImpl(
                7000,
                LocalDate.now().plusDays(20)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        Caminhao caminhao = new Caminhao(piloto, tripulacao, 0.14, 10);

        // Act
        boolean pilotoLicencasValidas = caminhao.getPiloto().licencasValidas();

        // Assert
        assertTrue(pilotoLicencasValidas);
    }

    @Test
    public void devePossuirPilotoComLicencasInvalidasQuandoPilotoPossuirLicencasInvalidas() {
        // Arrange
        PilotoTanqueImpl piloto = new PilotoTanqueImpl(
                7000,
                LocalDate.now().minusYears(1)
        );

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        Tanque tanque = new Tanque(piloto, tripulacao, 0.14, 10);

        // Act
        boolean pilotoLicencasValidas = tanque.getPiloto().licencasValidas();

        // Assert
        assertFalse(pilotoLicencasValidas);
    }
}
