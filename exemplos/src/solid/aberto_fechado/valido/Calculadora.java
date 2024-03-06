package solid.aberto_fechado.valido;

public class Calculadora {

    public void calcular(OperacaoCalculo operacao) {
        if (operacao == null) {
            throw new IllegalArgumentException("Não pode executar operação!");
        }
        operacao.executar();
    }

}
