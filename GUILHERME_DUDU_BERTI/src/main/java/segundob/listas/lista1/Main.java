package segundob.listas.lista1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("ATV 1___");
        List<String> nomes = new ArrayList<>(List.of("Rafael", "Anderson", "Bernardo", "Kauê", "Lucas"));
        nomes.forEach(nome -> System.out.println("G - " + nome));

        System.out.println("\nATV 2___");
        HashSet<Integer> numInt = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 5, 3, 1));
        System.out.println("Existe o número 3? " + numInt.contains(3));
        System.out.println("Lista de números: ");
        numInt.forEach(number -> System.out.print(number + ", "));

        System.out.println("\nATV 3___");
        atvTres();

        System.out.println("\nATV 4___");
        atvQuatro();

        System.out.println("\nATV 5___");
        atvCinco();
    }

    public static void atvTres() {
        List<String> jogosZerados = new ArrayList<>();
        jogosZerados.add("GTA SA");
        jogosZerados.add("GTA SA");
        jogosZerados.add("Minecraft");
        jogosZerados.add("Minecraft");
        jogosZerados.add("Minecraft");
        jogosZerados.add("Minecraft");
        jogosZerados.add("GOD OF WAR");
        List<String> jogosZeradosUnicos = new ArrayList<>(new HashSet<>(jogosZerados));
        System.out.println("Todos os jogos zerados únicos: ");
        jogosZeradosUnicos.forEach(System.out::println);
    }

    public static void atvQuatro() {
        Queue<String> melhoresAnimesSeries = new PriorityQueue<>();
        melhoresAnimesSeries.add("Naruto");
        melhoresAnimesSeries.add("Dragon Ball");
        melhoresAnimesSeries.add("La Casa de Papel");
        melhoresAnimesSeries.add("Captain Tsubasa");
        melhoresAnimesSeries.add("Pokémon");
        melhoresAnimesSeries.forEach(System.out::println);
    }

    public static void atvCinco() {
        Map<String, String> configuracoes = new HashMap<>();
        configuracoes.put("I5 2.5GHz", "700.00");
        configuracoes.put("RTX 3050", "2.000.00");
        configuracoes.put("120Hz", "500.00");
        configuracoes.put("Tela 120Hz", "1.000.00");
        configuracoes.put("Teclado Padrão", "200.00");

        for (Map.Entry<String, String> entry : configuracoes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
