package generics.pre_java_five;

import java.util.ArrayList;
import java.util.List;

public class PreJavaCinco {

    public static void main(String[] args) {
        List lista = new ArrayList();

        lista.add("eE");
        lista.add(100);
        lista.add('c');

        String string = (String) lista.get(0);
        Integer inteiro = (Integer) lista.get(1);
        Character caractere = (Character) lista.get(2);
    }

}
