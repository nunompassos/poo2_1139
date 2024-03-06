package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;
import solid.substituicao_liskov.ExcecaoPagamentoFalhado;

public interface MeioDePagamamento {
    void validar() throws ExcecaoMeioPagamentoInvalido;
    RespostaDePagamento pagar() throws ExcecaoPagamentoFalhado;
}
