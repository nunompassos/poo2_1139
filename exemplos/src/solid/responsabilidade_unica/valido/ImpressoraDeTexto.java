package solid.responsabilidade_unica.valido;

import java.util.Arrays;

public class ImpressoraDeTexto {
    private ManipuladorDeTexto manipuladorDeTexto;

    public ImpressoraDeTexto(ManipuladorDeTexto manipuladorDeTexto) {
        this.manipuladorDeTexto = manipuladorDeTexto;
    }

    public void imprimirTexto() {
        System.out.println(this.manipuladorDeTexto.getTexto());
    }

    public void imprimirCadaPalavraDoTexto() {
        System.out.println(Arrays.toString(this.manipuladorDeTexto.getTexto().split(" ")));
    }

    public void imprimirIntervaloDeCaracteres(int inicio, int fim) {
        System.out.println(this.manipuladorDeTexto.getTexto().substring(inicio, fim));
    }
}
