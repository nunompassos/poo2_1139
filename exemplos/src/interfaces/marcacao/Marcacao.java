package interfaces.marcacao;

import java.util.ArrayList;
import java.util.List;

public class Marcacao {

    public static void main(String[] args) {
        List<Ave> gaiola = new ArrayList<>();

        Tucano tucano = new Tucano();
        Pardal pardal = new Pardal();

        gaiola.add(tucano);
        gaiola.add(pardal);
    }

}
