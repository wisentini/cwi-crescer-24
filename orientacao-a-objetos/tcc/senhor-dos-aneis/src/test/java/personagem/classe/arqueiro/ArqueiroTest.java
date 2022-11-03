package personagem.classe.arqueiro;

import mapa.Mapa;

import personagem.legolas.Legolas;
import personagem.orc.Orc;
import personagem.urukhai.Urukhai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArqueiroTest {
    @Test
    public void deveAtacarPersonagemInimigoDistante() {
        // Arrange
        Legolas legolas = new Legolas();
        Urukhai urukhai = new Urukhai();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        mapa.inserir(2, legolas);
        mapa.inserir(3, urukhai);
        mapa.inserir(5, orc);

        int distancia = 3;
        int dano = distancia * legolas.getAgilidade();

        int constituicaoPreAtaqueOrc = orc.getConstituicao();

        int constituicaoEsperadaPosAtaqueOrc = constituicaoPreAtaqueOrc - dano;

        // Act
        legolas.atacar(mapa);

        // Assert
        assertEquals(constituicaoEsperadaPosAtaqueOrc, orc.getConstituicao());
    }

    @Test
    public void deveAtacarPersonagemInimigoProximo() {
        // Arrange
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        mapa.inserir(2, legolas);
        mapa.inserir(3, orc);

        int distancia = 1;
        int dano = distancia * legolas.getAgilidade();

        int constituicaoPreAtaqueOrc = orc.getConstituicao();

        int constituicaoEsperadaPosAtaqueOrc = constituicaoPreAtaqueOrc - dano;

        // Act
        legolas.atacar(mapa);

        // Assert
        assertEquals(constituicaoEsperadaPosAtaqueOrc, orc.getConstituicao());
    }

    @Test
    public void naoDeveAtacarPersonagemInimigoMuitoDistante() {
        // Arrange
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        mapa.inserir(2, legolas);
        mapa.inserir(6, orc);

        int constituicaoOrc = orc.getConstituicao();

        // Act
        legolas.atacar(mapa);

        // Assert
        assertEquals(constituicaoOrc, orc.getConstituicao());
    }

    @Test
    public void deveAvancar2Casas() {
        // Arrange
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        int posicaoInicial = 2;

        mapa.inserir(posicaoInicial, legolas);
        mapa.inserir(8, orc);

        int posicaoFinalEsperada = posicaoInicial + 2;

        // Act
        legolas.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(legolas);

        // Assert
        assertEquals(posicaoFinalEsperada, posicaoFinal);
    }

    @Test
    public void deveAvancar1Casa() {
        // Arrange
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        int posicaoInicial = 2;

        mapa.inserir(posicaoInicial, legolas);
        mapa.inserir(4, orc);

        int posicaoFinalEsperada = posicaoInicial + 1;

        // Act
        legolas.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(legolas);

        // Assert
        assertEquals(posicaoFinalEsperada, posicaoFinal);
    }

    @Test
    public void naoDeveMovimentar() {
        // Arrange
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        int posicaoInicial = 2;

        mapa.inserir(posicaoInicial, legolas);
        mapa.inserir(3, orc);

        // Act
        legolas.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(legolas);

        // Assert
        assertEquals(posicaoInicial, posicaoFinal);
    }
}
