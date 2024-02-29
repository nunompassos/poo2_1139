package tech.ada.e_commerce.domain.cliente;

import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

public class Cliente {

    private final String id;
    private final Tipo tipo;
    private String nome;
    private String email;
    private Endereco endereco;
    private boolean ativo = true;

    private Cliente(
        String id,
        Tipo tipo,
        String nome,
        String email,
        Endereco endereco
    ) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        validar();
    }

    public static Cliente criar(
        String id,
        Tipo tipo,
        String nome,
        String email,
        Endereco endereco
    ) {
        return new Cliente(id, tipo, nome, email, endereco);
    }

    public void atualizarEndereco(Endereco novoEndereco) {
        this.endereco = novoEndereco;
    }

    public void altearNome(String novoNome) {
        this.nome = novoNome;
    }

    public void alterarEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public String id() {
        return id;
    }

    public Tipo tipo() {
        return tipo;
    }

    public String nome() {
        return nome;
    }

    public String email() {
        return email;
    }

    public Endereco endereco() {
        return endereco;
    }

    private void validar() {
        if (id == null) {
            throw new RuntimeException("ID não pode ser nulo");
        }

        if (nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("Nome não pode ser nulo");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new RuntimeException("Email não pode ser nulo");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
            "id=" + id +
            ", tipo=" + tipo +
            ", nome='" + nome + '\'' +
            ", email='" + email + '\'' +
            ", endereco=" + endereco +
            '}';
    }

    public void apagar() {
        this.ativo = false;
    }
}
