public class Calculadora {
    public Calculadora() {}

    public double somar(double valorA, double valorB) {
        return valorA + valorB;
    }

    public double subtrair(double valorA, double valorB) {
        return valorA - valorB;
    }

    public double multiplicar(double valorA, double valorB) {
        return valorA * valorB;
    }

    public double dividir(double valorA, double valorB) {
        return valorA / valorB;
    }

    public double calcularRaizQuadrada(double valor) {
        return Math.sqrt(valor);
    }

    public double calcularExponencial(double valor) {
        return Math.exp(valor);
    }

    public double calcularPotencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double calcularSomaRaizesBhaskara(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        double raizA = (-b + Math.sqrt(delta)) / (2 * a);
        double raizB = (-b - Math.sqrt(delta)) / (2 * a);
        return raizA + raizB;
    }
}
