import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lista2Atv2 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");

        List<String> nomesMaiusculas = nomes.stream()
                .map(nome -> nome.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(nomesMaiusculas);
    }
}
