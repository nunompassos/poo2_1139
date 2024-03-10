package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoFraudeDetetada;

public class ValidadorSerasaExperian implements ValidadorDeFraude {
    @Override
    public void executarValidacoes() throws ExcecaoFraudeDetetada {
        // comunicar dados à Serasa Experian para validações de fraude
    }
}
