package tech.ada.e_commerce.infraestrutura.pedido;

import java.util.ArrayList;
import java.util.List;

import tech.ada.e_commerce.domain.pedido.Pedido;
import tech.ada.e_commerce.domain.pedido.PedidoGateway;
import tech.ada.e_commerce.domain.pedido.PedidoId;

public class PedidoListaGateway implements PedidoGateway {

    List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void atualizar(PedidoId id, Pedido pedido) {
        pedidos.remove(pedido);
        pedidos.add(pedido);
    }

    @Override
    public void remover(PedidoId id) {
        pedidos.remove(id);
    }

    @Override
    public Pedido buscar(Integer id) {
        for (Pedido pedido : pedidos) {
            if (pedido.id().valor().equals(id)) {
                return pedido;
            }
        }
        throw new RuntimeException("Pedido não encontrado");
    }

    @Override
    public List<Pedido> buscarTodos() {
        return pedidos;
    }

}
