package generics.outra_utilizacao;

public class TransformarInteiroEmString implements Comando<Integer, String>{

    @Override
    public String executar(Integer input) {
        return String.valueOf(input);
    }
}
