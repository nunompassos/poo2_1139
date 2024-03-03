package tech.ada.e_commerce.domain.cliente.objetos;

import tech.ada.e_commerce.domain.Identificador;

public class CNPJ extends Identificador<String> {

    private final String valor;

    private CNPJ(String valor) {
        this.valor = valor;
        this.validar();
    }

    public static CNPJ criar(String id) {
        return new CNPJ(id);
    }

    public String valor() {
        return this.valor;
    }

    private void validar() {
        if (valor == null || valor.length() != 14) {
            throw new IllegalArgumentException("CNPJ são 14 caracteres!");
        }
    }

}
