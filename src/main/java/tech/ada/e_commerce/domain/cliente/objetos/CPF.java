package tech.ada.e_commerce.domain.cliente.objetos;

import tech.ada.e_commerce.domain.Identificador;

public class CPF extends Identificador<String> {

    private final String valor;

    private CPF(String valor) {
        this.valor = valor;
        this.validar();
    }

    public static CPF criar(String id) {
        return new CPF(id);
    }

    public String getValor() {
        return this.valor;
    }

    private void validar() {
        if (this.valor == null || this.valor.length() != 11) {
            throw new IllegalArgumentException("CPF são 11 caracteres!");
        }
    }

}
