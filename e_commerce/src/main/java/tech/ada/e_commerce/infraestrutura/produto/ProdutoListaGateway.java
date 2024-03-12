package tech.ada.e_commerce.infraestrutura.produto;

import java.util.ArrayList;
import java.util.List;

import tech.ada.e_commerce.domain.produto.Produto;
import tech.ada.e_commerce.domain.produto.ProdutoGateway;

public class ProdutoListaGateway implements ProdutoGateway {

    List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvar(Produto cliente) {
        produtos.add(cliente);
    }

    @Override
    public void atualizar(Produto cliente) {
        produtos.remove(cliente);
        produtos.add(cliente);
    }

    @Override
    public Produto buscarPorId(Integer id) {

        for (Produto produto : produtos) {
            if (produto.id().valor().equals(id)) {
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    @Override
    public Produto buscarPorDescricao(String descricao) {
        return produtos.stream()
            .filter(cliente -> cliente.descricao().equals(descricao))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtos;
    }

}
