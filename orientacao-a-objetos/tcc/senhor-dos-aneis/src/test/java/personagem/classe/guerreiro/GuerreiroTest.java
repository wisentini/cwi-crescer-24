package personagem.classe.guerreiro;

import mapa.Mapa;

import personagem.aragorn.Aragorn;
import personagem.boromir.Boromir;
import personagem.gimli.Gimli;
import personagem.orc.Orc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GuerreiroTest {
    @Test
    public void deveAtacarPersonagemInimigoProximo() {
        // Assert
        Aragorn aragorn = new Aragorn();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        mapa.inserir(2, aragorn);
        mapa.inserir(3, orc);

        int dano = 2 * aragorn.getForca();

        int constituicaoPreAtaqueOrc = orc.getConstituicao();
        int constituicaoEsperadaPosAtaqueOrc = constituicaoPreAtaqueOrc - dano;

        // Act
        aragorn.atacar(mapa);

        // Assert
        assertEquals(constituicaoEsperadaPosAtaqueOrc, orc.getConstituicao());
    }

    @Test
    public void naoDeveAtacarPersonagemInimigoDistante() {
        // Assert
        Gimli gimli = new Gimli();
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        mapa.inserir(1, gimli);
        mapa.inserir(3, orc);

        int constituicaoOrc = orc.getConstituicao();

        // Act
        gimli.atacar(mapa);

        // Assert
        assertEquals(constituicaoOrc, orc.getConstituicao());
    }

    @Test
    public void deveMovimentarQuandoHouverUmaPosicaoLivreEmSuaFrente() {
        // Arrange
        Boromir boromir = new Boromir();
        Mapa mapa = new Mapa();

        int posicaoInicial = 2;

        mapa.inserir(posicaoInicial, boromir);

        int posicaoFinalEsperada = posicaoInicial + 1;

        // Act
        boromir.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(boromir);

        // Assert
        assertEquals(posicaoFinalEsperada, posicaoFinal);
    }

    @Test
    public void orcDeveMovimentarQuandoHouverUmaPosicaoLivreEmSuaFrente() {
        // Arrange
        Orc orc = new Orc();
        Mapa mapa = new Mapa();

        int posicaoInicial = 6;

        mapa.inserir(posicaoInicial, orc);

        int posicaoFinalEsperada = posicaoInicial - 1;

        // Act
        orc.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(orc);

        // Assert
        assertEquals(posicaoFinalEsperada, posicaoFinal);
    }

    @Test
    public void naoDeveMovimentarQuandoNaoHouverUmaPosicaoLivreEmSuaFrente() {
        // Arrange
        Boromir boromir = new Boromir();
        Gimli gimli = new Gimli();
        Mapa mapa = new Mapa();

        int posicaoInicial = 2;

        mapa.inserir(posicaoInicial, boromir);
        mapa.inserir(3, gimli);

        // Act
        boromir.movimentar(mapa);
        int posicaoFinal = mapa.buscarPosicao(boromir);

        // Assert
        assertEquals(posicaoInicial, posicaoFinal);
    }
}
