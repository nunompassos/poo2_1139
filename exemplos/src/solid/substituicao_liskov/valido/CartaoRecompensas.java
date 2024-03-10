package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;
import solid.substituicao_liskov.ExcecaoPagamentoFalhado;

public class CartaoRecompensas implements MeioDePagamamento {
    String nome;
    String numeroCartao;

    @Override
    public void validar() throws ExcecaoMeioPagamentoInvalido {
        // validações relacionadas com o cartão de recompensas
    }

    @Override
    public RespostaDePagamento pagar() throws ExcecaoPagamentoFalhado {
        RespostaDePagamento resposta = new RespostaDePagamento();
        // passos relacionados com o pagamento com o cartão de recompensas
        // como buscar o saldo de pontos de recompensa, atualizar o saldo, etc...
        resposta.definirIdentificador(numeroCartao);
        return resposta;
    }
}
