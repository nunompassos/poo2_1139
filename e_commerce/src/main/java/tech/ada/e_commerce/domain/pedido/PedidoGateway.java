package tech.ada.e_commerce.domain.pedido;

import java.util.List;

public interface PedidoGateway {

    void salvar(Pedido pedido);

    void atualizar(PedidoId id, Pedido pedido);

    void remover(PedidoId id);

    Pedido buscar(Integer id);

    List<Pedido> buscarTodos();

}
