package tech.ada.e_commerce.domain.produto;

import tech.ada.e_commerce.domain.Identificador;

public class ProdutoId extends Identificador<Integer> {

    private static Integer id = 0;
    private final Integer valor;

    private ProdutoId() {
        ProdutoId.id++;
        this.valor = id;
    }

    private ProdutoId(Integer valor) {
        this.valor = valor;
    }

    public static ProdutoId criar(Integer valor) {
        return new ProdutoId(valor);
    }

    public static ProdutoId criar() {
        return new ProdutoId();
    }

    @Override
    public Integer valor() {
        return valor;
    }

}
