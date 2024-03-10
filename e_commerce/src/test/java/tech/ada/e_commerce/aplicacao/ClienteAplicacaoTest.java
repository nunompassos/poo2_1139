package tech.ada.e_commerce.aplicacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

public class ClienteAplicacaoTest {

    final private MockedClienteGateway clienteGateway = new MockedClienteGateway();
    final private ClienteAplicacao teste = new ClienteAplicacao(clienteGateway);

    private final static ClienteDto CLIENTE_PF = new ClienteDto(
        "11111111111",
        "Pessoa Fisica",
        "pessoa.fisica@email.com",
        "Logradouro",
        "Bairro",
        "11111111",
        "Cidade",
        "Estado",
        Tipo.FISICA
    );

    private final static ClienteDto CLIENTE_PF_INVALIDO = new ClienteDto(
        "1111111111",
        "Pessoa Fisica",
        "pessoa.fisica@email.com",
        "Logradouro",
        "Bairro",
        "11111111",
        "Cidade",
        "Estado",
        Tipo.FISICA
    );

    @Test
    @DisplayName("Adicionar um cliente PF com sucesso")
    public void adicionarClientePFComSucesso() {
        teste.adicionarCliente(CLIENTE_PF);
    }

    @Test
    @DisplayName("Adicionar um cliente PF com CPF inválido dá uma Exceção")
    public void adicionarClientePFComCPFInvalido() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> teste.adicionarCliente(CLIENTE_PF_INVALIDO));
        Assertions.assertEquals("CPF são 11 caracteres!", exception.getMessage());
    }
}
