package nave;

import planeta.Planeta;
import planeta.PrioridadeExploracao;
import recurso.Recurso;

import java.util.*;
import java.util.stream.Collectors;

public class Nave {
    private static final int CONSUMO_COMBUSTIVEL_POSICAO = 3;

    private int quantidadeDeCombustivel;
    private int posicao;

    public Nave(int quantidadeDeCombustivel) {
        this.quantidadeDeCombustivel = quantidadeDeCombustivel;
        this.posicao = 0;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public int getQuantidadeDeCombustivel() {
        return this.quantidadeDeCombustivel;
    }

    public List<Recurso> explorar(Planeta planeta) {
        while (this.quantidadeDeCombustivel > 0 && this.posicao != planeta.getPosicao()) {
            this.posicao++;
            this.quantidadeDeCombustivel -= CONSUMO_COMBUSTIVEL_POSICAO;
        }

        List<Recurso> recursos = new ArrayList<>();

        if (this.posicao == planeta.getPosicao()) {
            recursos = planeta.getRecursos();
        }

        while (this.quantidadeDeCombustivel > 0 && this.posicao != 0) {
            this.posicao--;
            this.quantidadeDeCombustivel -= CONSUMO_COMBUSTIVEL_POSICAO;
        }

        return recursos;
    }

    private List<Planeta> priorizarPlanetas(List<Planeta> planetas, PrioridadeExploracao prioridadeExploracao) {
        return switch (prioridadeExploracao) {
            case POSICAO -> planetas.stream().sorted(Comparator.comparing(Planeta::getPosicao)).collect(Collectors.toList());
            case VALOR_TOTAL -> planetas.stream().sorted(Comparator.comparing(Planeta::getValorTotal, Comparator.reverseOrder())).collect(Collectors.toList());
            case VALOR_TOTAL_POR_PESO -> planetas.stream().sorted(Comparator.comparing(Planeta::getValorTotalPorPeso, Comparator.reverseOrder())).collect(Collectors.toList());
        };
    }

    public List<Recurso> explorar(List<Planeta> planetas, PrioridadeExploracao prioridadeExploracao) {
        List<Planeta> planetasPriorizados = this.priorizarPlanetas(planetas, prioridadeExploracao);
        List<Recurso> recursos = new ArrayList<>();
        Iterator<Planeta> iteradorPlanetas = planetasPriorizados.iterator();

        while (iteradorPlanetas.hasNext() && this.quantidadeDeCombustivel > 0) {
            Planeta planeta = iteradorPlanetas.next();

            while (this.quantidadeDeCombustivel > 0 && this.posicao != planeta.getPosicao()) {
                this.posicao += this.posicao < planeta.getPosicao() ? 1 : -1;
                this.quantidadeDeCombustivel -= CONSUMO_COMBUSTIVEL_POSICAO;
            }

            if (this.posicao == planeta.getPosicao()) {
                recursos.addAll(planeta.getRecursos());
            }
        }

        while (this.quantidadeDeCombustivel > 0 && this.posicao != 0) {
            this.posicao--;
            this.quantidadeDeCombustivel -= CONSUMO_COMBUSTIVEL_POSICAO;
        }

        return recursos;
    }
}
