package tech.ada.e_commerce.infraestrutura.cliente;

import java.util.ArrayList;
import java.util.List;

import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.ClienteGateway;

public class ClienteListaGateway implements ClienteGateway {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void registar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clientes.remove(cliente);
        clientes.add(cliente);
    }

    @Override
    public void apagar(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public Cliente buscarPorId(String id) {
        for (Cliente c : clientes) {
            if (c.id().toString().equals(id)) {
                return c;
            }
        }
        throw new RuntimeException("Cliente não encontrado!");
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clientes;
    }
}
