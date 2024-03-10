package tech.ada.e_commerce.aplicacao;

import java.util.List;

import tech.ada.e_commerce.domain.Identificador;
import tech.ada.e_commerce.domain.cliente.Cidade;
import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.ClienteGateway;
import tech.ada.e_commerce.domain.cliente.Endereco;
import tech.ada.e_commerce.domain.cliente.objetos.CEP;
import tech.ada.e_commerce.domain.cliente.objetos.CNPJ;
import tech.ada.e_commerce.domain.cliente.objetos.CPF;
import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

public class MockedClienteGateway implements ClienteGateway {

    private static final Endereco ENDERECO = Endereco.criar(
        CEP.criar("11111111"),
        "logradouro",
        "bairro",
        Cidade.criar("Cidade", "UF")
    );

    private static final Cliente CLIENTE_PF = Cliente.criar(
        CPF.criar("11111111111"),
        Tipo.FISICA,
        "Pessoa Fisica",
        "pessoa.fisica@email.com",
        ENDERECO
    );

    private static final Cliente CLIENTE_PJ = Cliente.criar(
        CNPJ.criar("11111111111111"),
        Tipo.JURIDICA,
        "Pessoa Juridica",
        "pessoa.juridica@email.com",
        ENDERECO
    );

    @Override
    public void registar(Cliente cliente) {

    }

    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public void apagar(Cliente cliente) {

    }

    @Override
    public Cliente buscarPorId(String id) {
        return CLIENTE_PF;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return List.of(CLIENTE_PF, CLIENTE_PJ);
    }
}
