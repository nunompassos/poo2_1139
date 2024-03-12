package tech.ada.e_commerce.infraestrutura.cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tech.ada.e_commerce.domain.cliente.Cidade;
import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.ClienteGateway;
import tech.ada.e_commerce.domain.cliente.Endereco;
import tech.ada.e_commerce.domain.cliente.objetos.CEP;
import tech.ada.e_commerce.domain.cliente.objetos.CNPJ;
import tech.ada.e_commerce.domain.cliente.objetos.CPF;
import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

// Ligar a uma base de dados H2
public class ClienteH2Gateway implements ClienteGateway {

    private final static String JDBC_URL = "jdbc:h2:~/e_commerce_db";
    private final static String TABELA_CLIENTE = """
        CREATE TABLE IF NOT EXISTS cliente (
            id         VARCHAR(255) PRIMARY KEY,
            tipo       VARCHAR(255),
            nome       VARCHAR(255),
            email      VARCHAR(255),
            enderecoId VARCHAR(255)
        );
        """;
    private final static String TABELA_ENDERECO = """
        CREATE TABLE IF NOT EXISTS endereco (
            id         VARCHAR(255) PRIMARY KEY,
            cep        VARCHAR(255),
            logradouro VARCHAR(255),
            bairro     VARCHAR(255),
            cidade     VARCHAR(255),
            uf         VARCHAR(255)
        );
        """;
    private final static String INSERIR_ENDERECO = """
        INSERT INTO endereco (id, cep, logradouro, bairro, cidade, uf)
                     values ( '%s', '%s' , '%s'        , '%s'    , '%s'    , '%s');
        """;
    private final static String INSERIR_CLIENTE = """
        INSERT INTO cliente (id, tipo, nome, email, enderecoId)
                     values ('%s', '%s'  , '%s'  , '%s'   , '%s');
        """;
    private final static String BUSCAR_CLIENTE_POR_ID = "SELECT * FROM cliente WHERE id = '%s';";
    private final static String BUSCAR_ENDERECO_POR_ID = "SELECT * FROM endereco WHERE id = '%s';";
    private final static String BUSCAR_TODOS_CLIENTES = "SELECT * FROM cliente;";

    private final EnderecoGateway enderecoGateway;

    public ClienteH2Gateway() {
        try (Connection c = connect()) {
            Statement statement = c.createStatement();
            statement.execute(TABELA_CLIENTE);
            statement.execute(TABELA_ENDERECO);
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel inicializar o banco de dados");
        }
    }

    @Override
    public void registar(Cliente cliente) {
        final UUID enderecoId = UUID.randomUUID();
        try (Connection c = connect()) {
            Statement statement = c.createStatement();
            enderecoGateway.salvar(....)
            statement.execute(
                String.format(
                    INSERIR_ENDERECO,
                    enderecoId,
                    cliente.endereco().getCep().valor(),
                    cliente.endereco().getLogradouro(),
                    cliente.endereco().getBairro(),
                    cliente.endereco().getCidade().nome(),
                    cliente.endereco().getCidade().uf()
                )
            );
            statement.execute(
                String.format(
                    INSERIR_CLIENTE,
                    cliente.id().valor(),
                    cliente.tipo().toString(),
                    cliente.nome(),
                    cliente.email(),
                    enderecoId
                )
            );
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public void apagar(Cliente cliente) {

    }

    @Override
    public Cliente buscarPorId(String id) {
        try (Connection c = connect()) {
            Statement statement = c.createStatement();
            ResultSet result = statement.executeQuery(
                String.format(BUSCAR_CLIENTE_POR_ID, id)
            );
            while (result.next()) {
                String enderecoId = result.getString("enderecoId");
                ResultSet enderecoResult = statement.executeQuery(
                    String.format(BUSCAR_ENDERECO_POR_ID, enderecoId)
                );
                enderecoResult.next();
                Cidade cidade = Cidade.criar(enderecoResult.getString("cidade"), enderecoResult.getString("uf"));
                Endereco endereco = Endereco.criar(
                    CEP.criar(enderecoResult.getString("cep")),
                    enderecoResult.getString("logradouro"),
                    enderecoResult.getString("bairro"),
                    cidade
                );
                String idCliente = result.getString("id");
                return Cliente.criar(
                    Tipo.valueOf(result.getString("tipo")) == Tipo.FISICA ? CPF.criar(idCliente) : CNPJ.criar(idCliente),
                    Tipo.valueOf(result.getString("tipo")),
                    result.getString("nome"),
                    result.getString("email"),
                    endereco
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        final List<Cliente> resultados = new ArrayList<>();
        try (Connection c = connect()) {
            Statement statement = c.createStatement();
            ResultSet result = statement.executeQuery(
                String.format(BUSCAR_TODOS_CLIENTES)
            );
            while (result.next()) {
                String enderecoId = result.getString("enderecoId");
                Statement enderecoStatement = connect().createStatement();
                ResultSet enderecoResult = enderecoStatement.executeQuery(
                    String.format(BUSCAR_ENDERECO_POR_ID, enderecoId)
                );
                enderecoResult.next();
                Cidade cidade = Cidade.criar(enderecoResult.getString("cidade"), enderecoResult.getString("uf"));
                Endereco endereco = Endereco.criar(
                    CEP.criar(enderecoResult.getString("cep")),
                    enderecoResult.getString("logradouro"),
                    enderecoResult.getString("bairro"),
                    cidade
                );
                String idCliente = result.getString("id");
                resultados.add(Cliente.criar(
                    Tipo.valueOf(result.getString("tipo")) == Tipo.FISICA ? CPF.criar(idCliente) : CNPJ.criar(idCliente),
                    Tipo.valueOf(result.getString("tipo")),
                    result.getString("nome"),
                    result.getString("email"),
                    endereco
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return resultados;
    }

    private Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL);
        System.out.println("Conectado ao banco de dados H2");
        return connection;
    }

}
