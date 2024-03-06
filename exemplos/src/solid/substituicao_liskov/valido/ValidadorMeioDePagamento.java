package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;

public interface ValidadorMeioDePagamento {
    void validar() throws ExcecaoMeioPagamentoInvalido;
}
