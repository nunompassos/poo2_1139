package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;

public class CartaoCredito extends CartaoBancarioBasico {
    public CartaoCredito(ValidadorMeioDePagamento meioDePagamento, ValidadorDeFraude fraude, ManipuladorDeProcessadorDePagamentos processador) {
        super(meioDePagamento, fraude, processador);
    }
    // construtor omitido

    @Override
    public void validar() throws ExcecaoMeioPagamentoInvalido {
        validadorBasico.validar();
        // validações adicionais para cartões de crédito
    }
}
