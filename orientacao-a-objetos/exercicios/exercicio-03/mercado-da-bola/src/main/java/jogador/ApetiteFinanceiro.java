package jogador;

public enum ApetiteFinanceiro {
    INDIFERENTE("Indiferente", 0),
    CONSERVADOR("Conservador", 0.4),
    MERCENARIO("Mercenário", 0.8);

    private final String legenda;
    private final double percentual;

    ApetiteFinanceiro(String legenda, double percentual) {
        this.legenda = legenda;
        this.percentual = percentual;
    }

    public double getPercentual() {
        return this.percentual;
    }

    @Override
    public String toString() {
        return this.legenda;
    }
}
