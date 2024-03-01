package tech.ada.e_commerce.domain;

public abstract class Identificador<T> {

    public T valor;

    @Override
    public String toString() {
        return this.valor.toString();
    }

}
