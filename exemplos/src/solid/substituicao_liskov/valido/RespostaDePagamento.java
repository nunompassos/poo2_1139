package solid.substituicao_liskov.valido;

public class RespostaDePagamento {
    private String identificador;

    public String buscarIdentificador() {
        return this.identificador;
    }

    public void definirIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
