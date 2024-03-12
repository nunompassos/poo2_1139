package tech.ada.e_commerce;

import tech.ada.e_commerce.aplicacao.ClienteAplicacao;
import tech.ada.e_commerce.aplicacao.ClienteDto;
import tech.ada.e_commerce.domain.cliente.Cidade;
import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.ClienteGateway;
import tech.ada.e_commerce.domain.cliente.Endereco;
import tech.ada.e_commerce.domain.cliente.objetos.CEP;
import tech.ada.e_commerce.domain.cliente.objetos.CNPJ;
import tech.ada.e_commerce.domain.cliente.objetos.CPF;
import tech.ada.e_commerce.domain.cliente.objetos.Tipo;
import tech.ada.e_commerce.infraestrutura.cliente.ClienteH2Gateway;
import tech.ada.e_commerce.infraestrutura.cliente.ClienteListaGateway;

public class Main {
    public static void main(String[] args) {

        ClienteGateway cG = new ClienteListaGateway();
        ClienteGateway clienteH2 = new ClienteH2Gateway();
        ClienteAplicacao cA = new ClienteAplicacao(clienteH2);

        ClienteDto cliente = new ClienteDto("11111111115", "Nuno", "email@email", "logradouro", "Bairro","11111111", "cidade", "Estado",Tipo.FISICA);
        cA.adicionarCliente(cliente);
        cA.imprimirClientes();

    }
}
