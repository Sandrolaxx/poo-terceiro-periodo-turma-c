import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lista2Atv6 {
    public static void main(String[] args) {
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> linguagensOrdenadas = linguagens.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());

        System.out.println(linguagensOrdenadas);
    }
}