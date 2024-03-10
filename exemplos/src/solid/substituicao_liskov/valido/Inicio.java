package solid.substituicao_liskov.valido;

import solid.substituicao_liskov.DetalhesOrdem;

public class Inicio {

    public static void main(String[] args) {
        DetalhesOrdem ordem = new DetalhesOrdem();

        ManipuladorDeProcessadorDePagamentos manipuladorDeProcessadorDePagamentos =
            new ManipuladorPagamento();

        ValidadorMeioDePagamento validador = new ValidadorBasicoCartoesBancarios();

        ValidadorDeFraude validadorFraudio = new ValidadorDeFraudeFraudio();
        ValidadorDeFraude validadorSerasa = new ValidadorSerasaExperian();

        CartaoCredito cartao = new CartaoCredito(validador, validadorFraudio, manipuladorDeProcessadorDePagamentos);
        CartaoDebito cartaoDebito = new CartaoDebito(validador, validadorSerasa, manipuladorDeProcessadorDePagamentos);
        CartaoRecompensas cartaoRecompensas = new CartaoRecompensas();

        ProcessadorPagamentos processadorPagamentos =
            new ProcessadorPagamentos();

        processadorPagamentos.processar(ordem, cartao);
        processadorPagamentos.processar(ordem, cartaoRecompensas);
    }

}
