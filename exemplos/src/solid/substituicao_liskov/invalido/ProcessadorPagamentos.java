package solid.substituicao_liskov.invalido;

import solid.substituicao_liskov.DetalhesOrdem;

public class ProcessadorPagamentos {

    void processar(DetalhesOrdem detalhesOrdem, MeioDePagamento meioDePagamento) {
        try {
            meioDePagamento.validar();
            meioDePagamento.excecutarValidacoesFraude();
            meioDePagamento.enviarParaProcessadorDePagamento();
            guardarNaBaseDeDados(detalhesOrdem, meioDePagamento);
        } catch (Exception e) {
            // tratamento de exceções
        }
    }

    void guardarNaBaseDeDados(DetalhesOrdem detalhesOrdem, MeioDePagamento meioDePagamento) {
        String impressaoDigital = meioDePagamento.buscarImpressaoDigital();
        // guardar impressão digital e detalhes da ordem na base de dados
    }
}
