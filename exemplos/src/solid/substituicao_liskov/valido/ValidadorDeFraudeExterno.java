package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoFraudeDetetada;

public class ValidadorDeFraudeExterno implements ValidadorDeFraude {
    // atributos omitidos

    @Override
    public void executarValidacoes() throws ExcecaoFraudeDetetada {
        // chamada a sistema externo omitida
    }
}
