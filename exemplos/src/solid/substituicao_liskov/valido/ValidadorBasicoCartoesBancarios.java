package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;

public class ValidadorBasicoCartoesBancarios implements ValidadorMeioDePagamento {
    private String nome;
    // atributos omitidos


    @Override
    public void validar() throws ExcecaoMeioPagamentoInvalido {
        // validação básica sobre o nome, número do cartão, etc...
        if (nome == null || nome.isEmpty()) {
            throw new ExcecaoMeioPagamentoInvalido("Nome é invalido!");
        }
    }
}
