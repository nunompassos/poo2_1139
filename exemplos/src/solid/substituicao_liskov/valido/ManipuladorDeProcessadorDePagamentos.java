package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoPagamentoFalhado;

public interface ManipuladorDeProcessadorDePagamentos {
    RespostaDeProcessadorDePagamentos gerirPagamento() throws ExcecaoPagamentoFalhado;
}
