package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoFraudeDetetada;

public interface ValidadorDeFraude {
    void executarValidacoes() throws ExcecaoFraudeDetetada;
}
