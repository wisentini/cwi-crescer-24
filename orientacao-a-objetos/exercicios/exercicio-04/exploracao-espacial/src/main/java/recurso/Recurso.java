package recurso;

public enum Recurso {
    AGUA("Água", 180, 10),
    OXIGENIO("Oxigênio", 300, 2),
    SILICIO("Silício", 60, 16),
    OURO("Ouro", 120, 25),
    FERRO("Ferro", 30, 32);

    private final String nome;
    private final int valor;
    private final int peso;

    Recurso(String nome, int valor, int peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public int getValor() {
        return this.valor;
    }

    public int getPeso() {
        return this.peso;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
