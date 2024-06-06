import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ATV1
        ArrayList<String> amigos = new ArrayList<>();
        amigos.add("Ricardo");
        amigos.add("Delei");
        amigos.add("Felipe");
        amigos.add("Cecilia");
        amigos.add("Armando");
        
        System.out.println("ATV1:");
        for (String nome : colegas) {
            System.out.println(nome.charAt(0) + " - " + nome);
        }
        
        // ATV2
        HashSet<Integer> numeros = new HashSet<>();
        numeros.add(3);
        numeros.add(7);
        numeros.add(3); 
        
        int numeroBuscado = 3;
        System.out.println("\nATV2:");
        System.out.println("O conjunto contém o número " + numeroBuscado + "? " + numeros.contains(numeroBuscado));
        
        // ATV3
        ArrayList<String> jogosZerados = new ArrayList<>();
        jogosZerados.add("The Last Of Us 2");
        jogosZerados.add("The Last Of Us 2");
        jogosZerados.add("Tom Clancy's Ghost Recon");
        jogosZerados.add("Red Dead Redempetion 2");
        
        System.out.println("\nATV3:");
        System.out.println("Lista de jogos zerados antes de remover duplicatas: " + jogosZerados);
        ArrayList<String> jogosUnicos = removerDuplicatas(jogosZerados);
        System.out.println("Lista de jogos zerados após remover duplicatas: " + jogosUnicos);
        
        // ATV4
        PriorityQueue<String> melhoresAnimes = new PriorityQueue<>();
        melhoresAnimes.add("Dragon Ball");
        melhoresAnimes.add("Dragon Ball Z");
        melhoresAnimes.add("Naruto");
        melhoresAnimes.add("One Piece");
        melhoresAnimes.add("HxH");
        
        System.out.println("\nATV4:");
        System.out.println("Melhores animes/filmes em ordem alfabética:");
        while (!melhoresAnimes.isEmpty()) {
            System.out.println(melhoresAnimes.poll());
        }
        
        // ATV5
        HashMap<String, String> configuracoesHardware = new HashMap<>();
        configuracoesHardware.put("Processador", "i5 7500U");
        configuracoesHardware.put("Placa de vídeo", "NVIDIA GTX 1660 Ti");
        configuracoesHardware.put("Memória RAM", "16GB DDR4");
        configuracoesHardware.put("Armazenamento", "SSD 512GB");
        configuracoesHardware.put("Monitor", "27'' 144Hz IPS");
        
        System.out.println("\nATV5:");
        System.out.println("Configurações de hardware:");
        for (Map.Entry<String, String> entry : configuracoesHardware.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static ArrayList<String> removerDuplicatas(ArrayList<String> lista) {
        HashSet<String> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }
}
