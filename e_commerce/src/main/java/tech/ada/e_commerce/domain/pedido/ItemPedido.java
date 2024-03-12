package tech.ada.e_commerce.domain.pedido;

import java.math.BigDecimal;

import tech.ada.e_commerce.domain.produto.Produto;

public class ItemPedido {
    private final Produto produto;
    private final Integer quantidade;
    private final BigDecimal valor;

    private ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = produto.preco().multiply(new BigDecimal(quantidade));
        validar();
    }

    public static ItemPedido criar(Produto produto, Integer quantidade) {
        return new ItemPedido(produto, quantidade);
    }

    public Produto produto() {
        return produto;
    }

    public Integer quantidade() {
        return quantidade;
    }

    public BigDecimal valor() {
        return valor;
    }

    public void validar() {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não informado");
        }
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
            "produto=" + produto +
            ", quantidade=" + quantidade +
            ", valor=" + valor +
            '}';
    }
}
