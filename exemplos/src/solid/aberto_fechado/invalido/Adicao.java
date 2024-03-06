package solid.aberto_fechado.invalido;

public class Adicao implements OperacaoCalculo{
    private double esquerda;
    private double direita;
    private double resultado = 0.0;

    public Adicao(double esquerda, double direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public double getEsquerda() {
        return this.esquerda;
    }

    public double getDireita() {
        return this.direita;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
