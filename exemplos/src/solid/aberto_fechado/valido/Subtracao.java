package solid.aberto_fechado.valido;

public class Subtracao implements OperacaoCalculo{
    private final double esquerda;
    private final double direita;
    private double resultado = 0.0;

    public Subtracao(double esquerda, double direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public void executar() {
        this.resultado = this.esquerda - this.direita;
    }
}
