package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.DetalhesOrdem;

public class ProcessadorPagamentos {

    void processar(DetalhesOrdem detalhesOrdem, MeioDePagamamento meioDePagamamento) {
        try {
            meioDePagamamento.validar();
            RespostaDePagamento resposta = meioDePagamamento.pagar();
            guardarNaBaseDeDados(detalhesOrdem, resposta.buscarIdentificador());
        } catch (Exception e) {
            // tratamento de exceções
        }
    }

    void guardarNaBaseDeDados(DetalhesOrdem detalhesOrdem, String identificador) {
        // guardar identificador e detalhes da ordem na base de dados
    }

}
