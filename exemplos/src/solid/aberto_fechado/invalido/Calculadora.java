package solid.aberto_fechado.invalido;

import java.security.InvalidParameterException;

public class Calculadora {

    public void calcular(OperacaoCalculo operacao) {
        if (operacao == null) {
            throw new InvalidParameterException("Não pode executar operação!");
        }

        if (operacao instanceof Adicao) {
            final Adicao adicao = (Adicao) operacao;
            adicao.setResultado(adicao.getEsquerda() + adicao.getDireita());
        } else if (operacao instanceof Subtracao) {
            final Subtracao subtracao = (Subtracao) operacao;
            subtracao.setResultado(subtracao.getEsquerda() - subtracao.getDireita());
        }
    }

}
