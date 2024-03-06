package generics.outra_utilizacao;

public class Absoluto implements Comando<Integer, Integer> {

    @Override
    public Integer executar(Integer input) {
        return Math.abs(input);
    }
}
