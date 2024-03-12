package tech.ada.e_commerce.aplicacao.pedido;

import java.util.ArrayList;
import java.util.List;

import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.ClienteGateway;
import tech.ada.e_commerce.domain.pedido.ItemPedido;
import tech.ada.e_commerce.domain.pedido.Pedido;
import tech.ada.e_commerce.domain.pedido.PedidoGateway;
import tech.ada.e_commerce.domain.pedido.PedidoId;
import tech.ada.e_commerce.domain.produto.Produto;
import tech.ada.e_commerce.domain.produto.ProdutoGateway;
import tech.ada.e_commerce.domain.produto.ProdutoId;

public class PedidoAplicacao {

    private final PedidoGateway pedidoGateway;
    private final ClienteGateway clienteGateway;
    private final ProdutoGateway produtoGateway;

    public PedidoAplicacao(
        PedidoGateway pedidoGateway,
        ClienteGateway clienteGateway,
        ProdutoGateway produtoGateway
    ) {
        this.pedidoGateway = pedidoGateway;
        this.clienteGateway = clienteGateway;
        this.produtoGateway = produtoGateway;
    }

    public void criar(String clienteId, List<ItemPedidoDto> itens) {

        Cliente cliente = clienteGateway.buscarPorId(clienteId);

        List<ItemPedido> itensPedido = new ArrayList<>();

        for (ItemPedidoDto itemPedidoDTO : itens) {

            ProdutoId produtoID = ProdutoId.criar(itemPedidoDTO.produtoId());
            Produto produto = produtoGateway.buscarPorId(produtoID.valor());

            ItemPedido itemPedido = ItemPedido.criar(produto, itemPedidoDTO.quantidade());

            itensPedido.add(itemPedido);
        }

        Pedido pedido = Pedido.criar(cliente, itensPedido);

        pedidoGateway.salvar(pedido);
    }

    public void adicionarProduto(PedidoId pedidoId, ItemPedidoDto itemPedidoDTO) {

        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());

        ProdutoId produtoID = ProdutoId.criar(itemPedidoDTO.produtoId());
        Produto produto = produtoGateway.buscarPorId(produtoID.valor());

        pedido.adicionarProduto(produto, itemPedidoDTO.quantidade());

        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public void removerProduto(PedidoId pedidoId, ProdutoId produtoId) {
        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());
        pedido.removerProduto(produtoId);
        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public void fecharPedido(PedidoId pedidoId) {
        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());
        pedido.fechar();
        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public void cancelarPedido(PedidoId pedidoId) {
        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());
        pedido.cancelar();
        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public Pedido buscar(PedidoId id) {
        return pedidoGateway.buscar(id.valor());
    }

    public List<Pedido> buscarTodos() {
        return pedidoGateway.buscarTodos();
    }

}
