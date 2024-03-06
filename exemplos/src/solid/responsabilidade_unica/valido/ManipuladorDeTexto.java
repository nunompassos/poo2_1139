package solid.responsabilidade_unica.valido;

public class ManipuladorDeTexto {
    private String texto;

    public ManipuladorDeTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }

    public void acrescentarTexto(String novoTexto) {
        this.texto = this.texto.concat(novoTexto);
    }

    public String encontrarPalavraESubstituir(String palavra, String novaPalavra) {
        if (this.texto.contains(palavra)) {
            this.texto = this.texto.replace(palavra, novaPalavra);
        }
        return this.texto;
    }

    public String encontrarPalavraEApagar(String palavra) {
        if (this.texto.contains(palavra)) {
            this.texto = this.texto.replace(palavra, "");
        }
        return this.texto;
    }
}
