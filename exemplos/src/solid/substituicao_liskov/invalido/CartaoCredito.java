package solid.substituicao_liskov.invalido;

import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;

public class CartaoCredito extends MeioDePagamento {
    @Override
    public void validar() throws ExcecaoMeioPagamentoInvalido {
        super.validar();
        // validações adicionais para cartões de crédito
    }

    // outro código especifico para cartões de crédito
}
