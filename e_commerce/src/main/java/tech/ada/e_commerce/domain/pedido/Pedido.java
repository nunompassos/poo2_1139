package tech.ada.e_commerce.domain.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.produto.Produto;
import tech.ada.e_commerce.domain.produto.ProdutoId;

public class Pedido {

    private PedidoId id;
    private Cliente cliente;
    private LocalDateTime data;
    private Status status;
    private List<ItemPedido> itens;
    private BigDecimal valorTotal;

    private Pedido(Cliente cliente, List<ItemPedido> itens) {
        this.id = PedidoId.criar();
        this.cliente = cliente;
        this.data = LocalDateTime.now();
        this.status = Status.ABERTO;
        this.itens = itens;
        valorTotal = new BigDecimal(0);
        for (ItemPedido itemPedido : itens) {
            valorTotal = valorTotal.add(itemPedido.valor());
        }
    }

    public static Pedido criar(Cliente cliente, List<ItemPedido> itens) {
        return new Pedido(cliente, itens);
    }

    public void fechar() {
        this.status = Status.FECHADO;
    }

    public void cancelar() {
        this.status = Status.CANCELADO;
    }

    public void removerProduto(ProdutoId produtoID) {
        if (produtoID == null) {
            throw new IllegalArgumentException("Item pedido ID não informado");
        }
        List<ItemPedido> itens = this.itens;
        for (ItemPedido itemPedido : itens) {
            if (itemPedido.produto().id().equals(produtoID)) {
                this.itens.remove(itemPedido);
                valorTotal = valorTotal.subtract(itemPedido.valor());
                break;
            }
        }
    }

    public void adicionarProduto(Produto produto, Integer quantidade) {
        ItemPedido itemPedido = ItemPedido.criar(produto, quantidade);
        this.itens.add(itemPedido);
        valorTotal = valorTotal.add(itemPedido.valor());
    }

    public Produto buscarProduto(ProdutoId produtoID) {
        if (produtoID == null) {
            throw new IllegalArgumentException("Produto ID não informado");
        }

        for (ItemPedido itemPedido : this.itens) {
            if (itemPedido.produto().id().equals(produtoID)) {
                return itemPedido.produto();
            }
        }
        throw new IllegalArgumentException(String.format("Nenum Produto econtrado com o ID %s", produtoID));
    }

    public PedidoId id() {
        return id;
    }

    public Cliente cliente() {
        return cliente;
    }

    public LocalDateTime data() {
        return data;
    }

    public Status status() {
        return status;
    }

    public List<ItemPedido> itens() {
        return itens;
    }

    public BigDecimal valorTotal() {
        return valorTotal;
    }

    public void validar() {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não informado");
        }
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Itens não informados");
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
            "id=" + id +
            ", cliente=" + cliente +
            ", data=" + data +
            ", status=" + status +
            ", itens=" + itens +
            ", valorTotal=" + valorTotal +
            '}';
    }

}
