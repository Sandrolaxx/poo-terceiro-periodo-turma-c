package segundob.aulas.aulaquatro;

import java.util.ArrayList;
import java.util.List;

public class GenericsSample {
    public static void main(String[] args) {

        Double valor = 20d;
        Integer valorDois = 40;
        String nome = "Teste";

        printaValor(valor);
        printaValor(valorDois);
        printaValor(nome);

        List<Integer> lista = new ArrayList<>();
    }
    
    public static <T> void printaValor(T classe) {
        System.out.println(classe.toString());
    }

}
