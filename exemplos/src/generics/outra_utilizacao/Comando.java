package generics.outra_utilizacao;

public interface Comando<IN, OUT> {

    OUT executar(IN input);
}
