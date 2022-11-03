package mapa;

import mapa.exception.*;

import personagem.Personagem;
import personagem.aragorn.Aragorn;
import personagem.gandalf.Gandalf;
import personagem.gimli.Gimli;
import personagem.goblim.Goblim;
import personagem.legolas.Legolas;
import personagem.orc.Orc;
import personagem.saruman.Saruman;
import personagem.urukhai.Urukhai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {
    @Test
    public void deveExibirMapaVazioQuandoNaoHouverNenhumPersonagemNele() {
        // Arrange
        Mapa mapa = new Mapa();
        String stringEsperada = "| | | | | | | | | | |";

        // Act
        String string = mapa.exibir();

        // Assert
        assertEquals(stringEsperada, string);
    }

    @Test
    public void deveExibirMapaComLegolasGimliOrcEGoblim() {
        // Arrange
        Legolas legolas = new Legolas();
        Gimli gimli = new Gimli();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();

        mapa.inserir(1, legolas);
        mapa.inserir(3, gimli);
        mapa.inserir(6, orc);
        mapa.inserir(9, goblim);

        String stringEsperada = "| |L| |I| | |O| | |M|";

        // Act
        String string = mapa.exibir();

        // Assert
        assertEquals(stringEsperada, string);
    }

    @Test
    public void deveInserirPersonagem() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Mapa mapa = new Mapa();

        int posicaoEsperada = 3;
        int numeroPersonagensEsperado = 1;

        // Act
        mapa.inserir(posicaoEsperada, gandalf);
        int posicao = mapa.buscarPosicao(gandalf);
        int numeroPersonagens = mapa.getNumeroPersonagens();

        // Assert
        assertEquals(posicaoEsperada, posicao);
        assertEquals(numeroPersonagensEsperado, numeroPersonagens);
    }

    @Test()
    public void deveLancarMapaCheioExceptionAoInserirPersonagem() throws PosicaoOcupadaException, MapaCheioException, PersonagemJaEstaNoMapaException {
        // Arrange
        Mapa mapa = new Mapa();

        // Assert
        assertThrows(MapaCheioException.class, () -> {
            for (int i = 0; i < Mapa.NUM_MAX_POSICOES + 1; i++) {
                Aragorn aragorn = new Aragorn();
                mapa.inserir(i, aragorn);
            }
        });
    }

    @Test()
    public void deveLancarPosicaoOcupadaExceptionAoInserirPersonagem() throws PosicaoOcupadaException, MapaCheioException, PersonagemJaEstaNoMapaException {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();

        mapa.inserir(8, gandalf);

        // Assert
        assertThrows(PosicaoOcupadaException.class, () -> mapa.inserir(8, urukhai));
    }

    @Test()
    public void deveLancarPersonagemJaEstaNoMapaExceptionAoInserirPersonagem() throws PosicaoOcupadaException, MapaCheioException, PersonagemJaEstaNoMapaException {
        // Arrange
        Saruman saruman = new Saruman();
        Mapa mapa = new Mapa();

        mapa.inserir(1, saruman);

        // Assert
        assertThrows(PersonagemJaEstaNoMapaException.class, () -> mapa.inserir(4, saruman));
    }

    @Test
    public void deveRemoverPersonagem() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Mapa mapa = new Mapa();

        int posicao = 5;
        int numeroPersonagensEsperado = 0;

        mapa.inserir(posicao, gandalf);

        // Act
        Personagem personagemRemovido = mapa.remover(posicao);
        Personagem personagemNaPosicao5 = mapa.buscarCasa(posicao);
        int numeroPersonagens = mapa.getNumeroPersonagens();

        // Assert
        assertEquals(gandalf, personagemRemovido);
        assertEquals(numeroPersonagensEsperado, numeroPersonagens);
        assertNull(personagemNaPosicao5);
    }

    @Test()
    public void deveLancarPosicaoSemPersonagemExceptionAoRemoverPersonagem() throws PosicaoSemPersonagemException {
        // Arrange
        Mapa mapa = new Mapa();

        // Assert
        assertThrows(PosicaoSemPersonagemException.class, () -> mapa.remover(3));
    }

    @Test
    public void deveBuscarPosicaoPersonagem() {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Mapa mapa = new Mapa();

        int posicaoEsperada = 8;

        mapa.inserir(posicaoEsperada, gandalf);

        // Act
        int posicao = mapa.buscarPosicao(gandalf);

        // Assert
        assertEquals(posicaoEsperada, posicao);
    }

    @Test()
    public void deveLancarPersonagemNaoEncontradoNoMapaExceptionAoBuscarPosicaoPersonagem() throws PersonagemNaoEncontradoNoMapaException {
        // Arrange
        Gandalf gandalf = new Gandalf();
        Mapa mapa = new Mapa();

        // Assert
        assertThrows(PersonagemNaoEncontradoNoMapaException.class, () -> mapa.buscarPosicao(gandalf));
    }
}
