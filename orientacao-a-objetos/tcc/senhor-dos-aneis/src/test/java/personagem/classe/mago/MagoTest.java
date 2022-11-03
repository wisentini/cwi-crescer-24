package personagem.classe.mago;

import mapa.Mapa;

import personagem.boromir.Boromir;
import personagem.gandalf.Gandalf;
import personagem.goblim.Goblim;
import personagem.orc.Orc;
import personagem.saruman.Saruman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagoTest {
    @Test
    public void deveAtacarTodosOsPersonagensInimigos() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Saruman saruman = new Saruman();
        Mapa mapa = new Mapa();

        mapa.inserir(2, gandalf);
        mapa.inserir(4, orc);
        mapa.inserir(7, goblim);
        mapa.inserir(9, saruman);

        int dano = gandalf.getInteligencia();

        int constituicaoPreAtaqueOrc = orc.getConstituicao();
        int constituicaoPreAtaqueGoblim = goblim.getConstituicao();
        int constituicaoPreAtaqueSaruman = saruman.getConstituicao();

        int constituicaoEsperadaPosAtaqueOrc = constituicaoPreAtaqueOrc - dano;
        int constituicaoEsperadaPosAtaqueGoblim = constituicaoPreAtaqueGoblim - dano;
        int constituicaoEsperadaPosAtaqueSaruman = constituicaoPreAtaqueSaruman - dano;

        // Act
        gandalf.atacar(mapa);

        // Assert
        assertEquals(constituicaoEsperadaPosAtaqueOrc, orc.getConstituicao());
        assertEquals(constituicaoEsperadaPosAtaqueGoblim, goblim.getConstituicao());
        assertEquals(constituicaoEsperadaPosAtaqueSaruman, saruman.getConstituicao());
    }

    @Test
    public void naoDeveAtacarQuandoNaoHouverinimigos() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Boromir boromir = new Boromir();
        Mapa mapa = new Mapa();

        mapa.inserir(2, gandalf);
        mapa.inserir(5, boromir);

        int constituicaoEsperadaPosAtaqueBoromir = boromir.getConstituicao();

        // Act
        gandalf.atacar(mapa);

        // Assert
        assertEquals(constituicaoEsperadaPosAtaqueBoromir, boromir.getConstituicao());
    }

    @Test
    public void deveMovimentarQuandoNaoHouverNenhumOutroPersonagemNoMapa() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Mapa mapa = new Mapa();

        int posicaoInicial = 2;

        mapa.inserir(posicaoInicial, gandalf);

        int posicaoFinalEsperada = posicaoInicial + 1;

        // Act
        gandalf.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(gandalf);

        // Assert
        assertEquals(posicaoFinalEsperada, posicaoFinal);
    }

    @Test
    public void naoDeveMovimentarQuandoHouverOutroPersonagemNoMapa() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Boromir boromir = new Boromir();
        Mapa mapa = new Mapa();

        int posicaoInicial = 1;

        mapa.inserir(posicaoInicial, gandalf);
        mapa.inserir(7, boromir);

        // Act
        gandalf.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(gandalf);

        // Assert
        assertEquals(posicaoInicial, posicaoFinal);
    }
}
