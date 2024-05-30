import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lista2Atv1 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> pares = (List<Integer>) numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(pares);

    }
}