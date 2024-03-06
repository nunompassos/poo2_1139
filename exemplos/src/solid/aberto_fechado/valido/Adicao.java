package solid.aberto_fechado.valido;

public class Adicao implements OperacaoCalculo {
    private double esquerda;
    private double direita;
    private double resultado = 0.0;

    public Adicao(double esquerda, double direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public void executar() {
        this.resultado = this.esquerda + this.direita;
    }
}
