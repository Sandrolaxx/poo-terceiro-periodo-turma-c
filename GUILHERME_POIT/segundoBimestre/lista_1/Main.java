package segundoBimestre.lista_1;

    import java.util.*;

    public class Main {
        public static void main(String[] args) {
            // ATIV1
            System.out.println("// Atividade 1");
            List<String> colegas = new ArrayList<>();
            colegas.add("Matheus");
            colegas.add("Renan");
            colegas.add("Antony");
            colegas.add("Ricardo");
            colegas.add("Guilherme");

            for (String nome : colegas) {
                System.out.println(nome.charAt(0) + " - " + nome);
            }

            // ATIV2
            System.out.println("\n// Atividade 2");
            Set<Integer> numeros = new HashSet<>();
            numeros.add(3);
            numeros.add(5);
            numeros.add(3);

            int numeroVerificar = 5;
            System.out.println("O conjunto contém o número " + numeroVerificar + "? " + numeros.contains(numeroVerificar));

            // ATIV3
            System.out.println("\n// Atividade 3");
            List<String> jogosZerados = Arrays.asList("The Last of Us", "God of War", "The Last of Us", "Persona 5", "God of War");
            List<String> jogosUnicos = removerDuplicatas(jogosZerados);
            System.out.println("Jogos únicos: " + jogosUnicos);

            // ATIV4
            System.out.println("\n// Atividade 4");
            List<String> animesFilmes = new ArrayList<>();
            animesFilmes.add("Death Note");
            animesFilmes.add("Naruto");
            animesFilmes.add("One Piece");
            animesFilmes.add("Attack on Titan");
            animesFilmes.add("Spirited Away");

            ordenarPorOrdemAlfabetica(animesFilmes);

            // ATIV5
            System.out.println("\n// Atividade 5");
            Map<String, String> hardware = new HashMap<>();
            hardware.put("Processador", "i5 7500U");
            hardware.put("Placa de Vídeo", "Nvidia GTX 1660");
            hardware.put("Memória RAM", "16GB DDR4");
            hardware.put("Armazenamento", "SSD 500GB");
            hardware.put("Monitor", "LG 27GL850");

            for (Map.Entry<String, String> entry : hardware.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        // Método para remover duplicatas de uma lista de strings
        private static List<String> removerDuplicatas(List<String> lista) {
            Set<String> set = new LinkedHashSet<>(lista);
            return new ArrayList<>(set);
        }

        // Método para ordenar uma lista alfabeticamente
        private static void ordenarPorOrdemAlfabetica(List<String> lista) {
            PriorityQueue<String> queue = new PriorityQueue<>(lista);
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
        }
    }


