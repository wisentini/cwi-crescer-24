package simulador;

import mapa.Mapa;
import personagem.Personagem;

public class Simulador {
    private final Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() {
        while (!this.mapa.temVencedor()) {
            for (int posicao : this.mapa.getPosicoes()) {
                Personagem personagem = this.mapa.buscarCasa(posicao);

                if (personagem != null) {
                    personagem.atacar(this.mapa);
                    personagem.movimentar(this.mapa);
                }
            }
        }
    }
}
