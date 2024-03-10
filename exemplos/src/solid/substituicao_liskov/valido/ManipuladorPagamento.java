package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoPagamentoFalhado;

public class ManipuladorPagamento implements ManipuladorDeProcessadorDePagamentos {
    // atributos omitidos

    @Override
    public RespostaDeProcessadorDePagamentos gerirPagamento() throws ExcecaoPagamentoFalhado {
        // enviar detalhes para o processador de pagamentos,
        // definir a impressão digital recebida do processador de pagamento
        return null;
    }
}
