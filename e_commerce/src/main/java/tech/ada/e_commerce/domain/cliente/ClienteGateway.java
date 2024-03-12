package tech.ada.e_commerce.domain.cliente;

import java.util.List;

public interface ClienteGateway {

    void registar(Cliente cliente);

    void atualizar(Cliente cliente);

    Cliente buscarPorId(String id);

    List<Cliente> buscarTodos();

}
