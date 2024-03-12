package tech.ada.e_commerce.domain.pedido;

import tech.ada.e_commerce.domain.Identificador;

public class PedidoId extends Identificador<Integer> {

    private static Integer id = 0;

    private final Integer valor;

    private PedidoId() {
        id++;
        this.valor = id;
    }

    public static PedidoId criar() {
        return new PedidoId();
    }

    @Override
    public Integer valor() {
        return valor;
    }

}
