package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoFraudeDetetada;
import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;
import solid.substituicao_liskov.ExcecaoPagamentoFalhado;

public abstract class CartaoBancarioBasico implements MeioDePagamamento {
    // atributos omitidos

    ValidadorMeioDePagamento validadorBasico;
    ValidadorDeFraude validadorDeFraude;
    ManipuladorDeProcessadorDePagamentos manipuladorDeProcessadorDePagamentos;

    public CartaoBancarioBasico(ValidadorMeioDePagamento meioDePagamento, ValidadorDeFraude fraude, ManipuladorDeProcessadorDePagamentos processador) {
        this.validadorBasico = meioDePagamento;
        this.validadorDeFraude = fraude;
        this.manipuladorDeProcessadorDePagamentos = processador;
    }

    @Override
    public void validar() throws ExcecaoMeioPagamentoInvalido {
        validadorBasico.validar();
    }

    @Override
    public RespostaDePagamento pagar() throws ExcecaoPagamentoFalhado {
        RespostaDePagamento resposta = new RespostaDePagamento();
        try {
            validadorDeFraude.executarValidacoes();
            RespostaDeProcessadorDePagamentos respostaPP = manipuladorDeProcessadorDePagamentos.gerirPagamento();
            resposta.definirIdentificador(respostaPP.buscarImpressaoDigital());
        } catch (ExcecaoFraudeDetetada e) {
            // tratamento de exceção
        }
        return resposta;
    }
}
