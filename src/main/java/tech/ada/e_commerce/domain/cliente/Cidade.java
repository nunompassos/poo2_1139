package tech.ada.e_commerce.domain.cliente;

public class Cidade {

    private final String nome;
    private final String uf;

    private Cidade(
        String nome,
        String uf
    ) {
        this.nome = nome;
        this.uf = uf;
        validar();
    }

    public Cidade criar(String nome, String uf) {
        return new Cidade(nome, uf);
    }

    public String nome() {
        return nome;
    }

    public String uf() {
        return this.uf;
    }

    private void validar() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }
        if (uf == null || uf.isBlank()) {
            throw new IllegalArgumentException("UF não pode ser vazio!");
        }
    }
}
