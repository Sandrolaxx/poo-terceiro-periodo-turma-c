package Segundobim;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class Listaum{
    public static void main(String[] args){
        //ATV1
        List<String>nomes = new ArrayList<String>();
        nomes.add("Sofia");
        nomes.add("João");
        nomes.add("Murilo");
        nomes.add("Jorge");
        nomes.add("Lucas");
        System.out.println("ATV1");
        for(String i :nomes){
            System.out.println(i.charAt(0)+ "-" +i);
        }

        //ATV2
        HashSet<Integer>numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(5);
        numeros.add(1);
        numeros.add(5);
        int num = 3;
        System.out.println("\nATV2");
        System.out.println("O conjunto contém o número: " +num +" ?");
        if(numeros.contains(num)){
            System.out.println("Sim, contém");
        } else{
            System.out.println("Não contém");
        }

        //ATV3
        List<String>jogos = new ArrayList<String>();
        jogos.add("The last of us");
        jogos.add("The elder scrools V: Skyrim");
        jogos.add("Read Dead Redemption");
        jogos.add("Marvel's Spider Man");
        jogos.add("Marvel's Spider Man");
        
        System.out.println("\nATV3");
        System.out.println("Lista: " +jogos);
        System.out.println("Lista nova: " +removerDuplicatas(jogos));

        //ATV4
        PriorityQueue<String> filmes = new PriorityQueue<>();
        filmes.add("Vingadores: Ultimato");
        filmes.add("Velozes e Furiosos 5");
        filmes.add("Continência do Amor");
        filmes.add("Gente Grande");
        filmes.add("Bad Boys");
        System.out.println("\nATV4");
        System.out.println("Os filmes em ordem alfabética: ");
        while(!filmes.isEmpty()){
            System.out.println(filmes.poll());
        }
        Map<String, String> hardware = new HashMap<>();
        hardware.put("Processador", "i5 7500U");
        hardware.put("Memória RAM", "16GB DDR4");
        hardware.put("Armazenamento", "512GB SSD");
        hardware.put("Placa de Vídeo", "NVIDIA GTX 1050");
        hardware.put("Placa Mãe", "ASUS B450M");
        System.out.println("\nATV5");
        System.out.println(hardware);

    }   
        
    public static List<String> removerDuplicatas(List<String> lista) {
        Set<String> setSemDuplicatas = new HashSet<>(lista);
        return new ArrayList<>(setSemDuplicatas);
    }                                                               
}