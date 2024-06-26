package segundobimestre.listas.list01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("======= Atv 1 ======= \n");
        atv1();
        System.out.println("\n======= Atv 2 =======\n");
        atv2();
        System.out.println("\n======= Atv 3 =======\n");
        atv3();
        System.out.println("\n======= Atv 4 =======\n");
        atv4();
        System.out.println("\n======= Atv 5 =======\n");
        atv5();
    }

    private static void atv1() {
        List<String> colegas = new ArrayList<>(List.of("Guilherme", "Anderson", "Kaue", "Lucas", "Bernardo"));

        colegas.forEach(colega -> System.out.println("R - " + colega));
    }

    private static void atv2() {
        Set<Integer> numeros = new HashSet<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(1);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(2);

        System.out.println(numeros.contains(4));
        numeros.forEach(System.out::println);
    }

    private static void atv3() {
        List<String> jogosZerados = new ArrayList<>(List.of("GTA V", "Assassn`s Creed Odssey", "Zelda", "GTA V", "Good off War"));
        jogosZerados = removeDuplicates(jogosZerados);
        jogosZerados.forEach(System.out::println);
    }

    private static List<String> removeDuplicates(List<String> listGames) {
        Set<String> listNotDuplicate = new HashSet<>(listGames);
        return listNotDuplicate.stream().toList();
    }

    private static void atv4() {
        Queue<String> animes = new PriorityQueue<>();
        animes.add("Berserk");
        animes.add("Naruto");
        animes.add("Dragon Ball Z");
        animes.add("One Piece");
        animes.add("Desencantados");
        animes.add("Attach on Titans");

        animes.forEach(System.out::println);
    }

    private static void atv5() {
        Map<String, String> configuracaoPc = new HashMap<>();

        configuracaoPc.put("Processador", "Ryzen 9 8900x");
        configuracaoPc.put("Memoria", "DDR5 64gb 6000MHz");
        configuracaoPc.put("Placa Mae", "Rog Strix B550");
        configuracaoPc.put("Placa Video", "Rog Strix Nvidea 4090");
        configuracaoPc.put("Armazenamento", "SSD Nvme 1Tb Kingston");

        configuracaoPc.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
