package solid.substituicao_liskov.valido;

public class CartaoDebito extends CartaoBancarioBasico {

    private CartaoDebito(ValidadorMeioDePagamento meioDePagamento, ValidadorDeFraude fraude, ManipuladorDeProcessadorDePagamentos processador) {
        super(meioDePagamento, fraude, processador);
    }

    public CartaoDebito(ValidadorMeioDePagamento meioDePagamento, ManipuladorDeProcessadorDePagamentos processador) {
        this(meioDePagamento, new ValidadorSerasaExperian(), processador);
    }
    // construtor omitido
}
