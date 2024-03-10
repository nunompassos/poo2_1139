package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoFraudeDetetada;

public class ValidadorDeFraudeFraudio implements ValidadorDeFraude {
    @Override
    public void executarValidacoes() throws ExcecaoFraudeDetetada {
        // comunicar dados à Fraudio para validações de fraude
    }
}
