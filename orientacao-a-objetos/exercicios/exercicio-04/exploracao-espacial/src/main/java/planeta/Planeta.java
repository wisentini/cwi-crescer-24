package planeta;

import recurso.Recurso;

import java.util.List;

public class Planeta {
    private final int posicao;
    private final List<Recurso> recursos;

    public Planeta(int posicao, List<Recurso> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public int getValorTotal() {
        int valorTotal = 0;

        for (Recurso recurso : recursos) {
            valorTotal += recurso.getValor();
        }

        return valorTotal;
    }

    public double getValorTotalPorPeso() {
        double valorTotal = 0;

        for (Recurso recurso : recursos) {
            valorTotal += ((double)recurso.getValor() / (double)recurso.getPeso());
        }

        return valorTotal;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public List<Recurso> getRecursos() {
        return this.recursos;
    }
}
