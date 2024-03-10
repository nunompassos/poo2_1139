package tech.ada.e_commerce.aplicacao;

import tech.ada.e_commerce.domain.Identificador;
import tech.ada.e_commerce.domain.cliente.Cidade;
import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.ClienteGateway;
import tech.ada.e_commerce.domain.cliente.Endereco;
import tech.ada.e_commerce.domain.cliente.objetos.CEP;
import tech.ada.e_commerce.domain.cliente.objetos.CNPJ;
import tech.ada.e_commerce.domain.cliente.objetos.CPF;
import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

public class ClienteAplicacao {

    private final ClienteGateway gateway;

    public ClienteAplicacao(ClienteGateway gateway) {
        this.gateway = gateway;
    }

    public void adicionarCliente(ClienteDto dto) {

        final Identificador idValido = dto.tipo() == Tipo.FISICA ? CPF.criar(dto.id()) : CNPJ.criar(dto.id());
        final CEP cep = CEP.criar(dto.cep());
        final Cidade cidade = Cidade.criar(dto.cidade(), dto.estado());
        final Endereco endereco = Endereco.criar(cep, dto.logradouro(), dto.bairro(), cidade);

        final Cliente cliente = Cliente.criar(idValido, dto.tipo(), dto.nome(), dto.email(), endereco);

        gateway.registar(cliente);
    }

    public void atualizarCliente(String clienteId, String nome, String email) {
        Cliente cliente = gateway.buscarPorId(clienteId);
        if (cliente == null) {
            throw new RuntimeException("Cliente não existe!");
        }

        cliente.altearNome(nome);
        cliente.alterarEmail(email);

        gateway.atualizar(cliente);
    }

    public void atualizarEndereço(ClienteDto dto) {
        final CEP cep = CEP.criar(dto.cep());
        final Cidade cidade = Cidade.criar(dto.cidade(), dto.estado());
        final Endereco endereco = Endereco.criar(cep, dto.logradouro(), dto.bairro(), cidade);

        final Cliente cliente = gateway.buscarPorId(dto.id());
        if (cliente == null) {
            throw new RuntimeException("Cliente não existe!");
        }

        cliente.atualizarEndereco(endereco);

        gateway.atualizar(cliente);
    }

    public void imprimirClientes() {
        gateway.buscarTodos().stream().forEach(System.out::println);
    }
}
