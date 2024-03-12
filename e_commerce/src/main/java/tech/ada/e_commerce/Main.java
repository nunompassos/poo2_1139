package tech.ada.e_commerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import tech.ada.e_commerce.aplicacao.cliente.ClienteAplicacao;
import tech.ada.e_commerce.aplicacao.cliente.ClienteDto;
import tech.ada.e_commerce.aplicacao.pedido.ItemPedidoDto;
import tech.ada.e_commerce.aplicacao.pedido.PedidoAplicacao;
import tech.ada.e_commerce.aplicacao.produto.ProdutoAplicacao;
import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.ClienteGateway;
import tech.ada.e_commerce.domain.cliente.objetos.Tipo;
import tech.ada.e_commerce.domain.pedido.Pedido;
import tech.ada.e_commerce.domain.pedido.PedidoGateway;
import tech.ada.e_commerce.domain.produto.Produto;
import tech.ada.e_commerce.domain.produto.ProdutoGateway;
import tech.ada.e_commerce.infraestrutura.cliente.ClienteH2Gateway;
import tech.ada.e_commerce.infraestrutura.cliente.ClienteListaGateway;
import tech.ada.e_commerce.infraestrutura.pedido.PedidoListaGateway;
import tech.ada.e_commerce.infraestrutura.produto.ProdutoListaGateway;

public class Main {
    public static void main(String[] args) {
        // Produto
        // Instancia do Produto Gateway
        // Instalncia d Produto Aplicação injetando o Gateway
        ProdutoGateway produtoGateway = new ProdutoListaGateway();
        ProdutoAplicacao produtoAplicacao = new ProdutoAplicacao(produtoGateway);

        //Criando o produto
        String nome = "Coca-cola";
        BigDecimal preco = BigDecimal.valueOf(4.50);
        Integer estoque = 10;
        produtoAplicacao.incluir(nome, preco, estoque);
        produtoAplicacao.incluir("Pepsi", BigDecimal.valueOf(4.10), 5);

        //Listando os produto
        List<Produto> listProduto = produtoGateway.buscarTodos();
        listProduto.forEach(System.out::println);

        // Cliente
        // Instancia do Cliente Gateway
        // Instalncia do Cliente Aplicação injetando o Gateway
        ClienteGateway clienteGateway = new ClienteListaGateway();
        //ClienteGateway clienteGateway = new ClienteH2Gateway();
        ClienteAplicacao clienteAplicacao = new ClienteAplicacao(clienteGateway);

        //Criando o cliente
        final String idCliente = String.valueOf((long) (Math.random() * 100000000000L));

        ClienteDto clienteDTO = new ClienteDto(
            Tipo.FISICA,
            idCliente,
            "João da Silva",
            "wKqgR@example.com",
            "Rua das Flores",
            "Vila A",
            "12345678",
            "São Paulo",
            "SP");
        clienteAplicacao.cadastrar(clienteDTO);

        //Listando os cliente
        List<Cliente> listCliente = clienteGateway.buscarTodos();
        listCliente.forEach(System.out::println);

        //Pedido
        //Instanciando o Pedido Gateway
        //Instanciando o Pedido Aplicação injetando o Gateway
        PedidoGateway pedidoGateway = new PedidoListaGateway();
        PedidoAplicacao pedidoAplicacao = new PedidoAplicacao(pedidoGateway, clienteGateway, produtoGateway);

        //Criando o pedido
        List<ItemPedidoDto> itens = new ArrayList<>();
        itens.add(new ItemPedidoDto(1, 1));
        itens.add(new ItemPedidoDto(2, 2));
        pedidoAplicacao.criar(idCliente, itens);

        //Listando os pedidos
        List<Pedido> listPedido = pedidoGateway.buscarTodos();
        listPedido.forEach(System.out::println);

    }
}
