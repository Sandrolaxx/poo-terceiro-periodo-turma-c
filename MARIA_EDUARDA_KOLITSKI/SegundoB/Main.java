package SegundoB;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> colegas = new ArrayList<>();
        colegas.add("Giullia");
        colegas.add("Eduarda");
        colegas.add("Clara");
        colegas.add("Erika");
        colegas.add("Isabela");
        
        System.out.println("=== Atividade 1 ===");
        for (String nome : colegas) {
            System.out.println(nome.charAt(0) + " - " + nome);
        }
        
        HashSet<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(3); 
        
        int numeroVerificar = 3;
        System.out.println("\n=== Atividade 2 ===");
        if (numeros.contains(numeroVerificar)) {
            System.out.println("O conjunto contém o número " + numeroVerificar);
        } else {
            System.out.println("O conjunto não contém o número " + numeroVerificar);
        }
        
        ArrayList<String> jogosZerados = new ArrayList<>();
        jogosZerados.add("The Witcher 3");
        jogosZerados.add("The Witcher 3");
        jogosZerados.add("Dark Souls");
        jogosZerados.add("Dark Souls");
        jogosZerados.add("Bloodborne");
        
        System.out.println("\n=== Atividade 3 ===");
        ArrayList<String> jogosUnicos = removerDuplicatas(jogosZerados);
        System.out.println("Jogos zerados únicos: " + jogosUnicos);
        
        PriorityQueue<String> melhoresAnimes = new PriorityQueue<>();
        melhoresAnimes.add("Death Note");
        melhoresAnimes.add("Attack on Titan");
        melhoresAnimes.add("Naruto");
        melhoresAnimes.add("Jujutsu");
        melhoresAnimes.add("Demon Slayer");
        
        System.out.println("\n=== Atividade 4 ===");
        System.out.println("Melhores animes/filmes ordenados:");
        while (!melhoresAnimes.isEmpty()) {
            System.out.println(melhoresAnimes.poll());
        }

        HashMap<String, String> configuracoesHardware = new HashMap<>();
        configuracoesHardware.put("Processador", "i5 7500U");
        configuracoesHardware.put("Placa de vídeo", "Nvidia GTX 1660 Ti");
        configuracoesHardware.put("Memória RAM", "16GB DDR4");
        configuracoesHardware.put("Armazenamento", "SSD 512GB");
        configuracoesHardware.put("Monitor", "LG Ultragear 144Hz");
        
        System.out.println("\n=== Atividade 5 ===");
        for (Map.Entry<String, String> entry : configuracoesHardware.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    private static ArrayList<String> removerDuplicatas(ArrayList<String> lista) {
        HashSet<String> conjunto = new HashSet<>(lista);
        return new ArrayList<>(conjunto);
    }
}