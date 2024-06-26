package KAUE_ORLANDINI.SegundoBimestre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //ATV1
        System.out.println("ATV 1");

        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("maju");
        nomes.add("marcelo");
        nomes.add("goncalves");
        nomes.add("mega");
        nomes.add("gufens");

        for(String e:nomes){
            System.out.println("K" + " - " + (e));
        }

        System.out.println(" ");

        //ATV2
        System.out.println("ATV 2");
       
        HashSet<Integer> numeros = new HashSet<>();

        numeros.add(4);
        numeros.add(13);
        numeros.add(20);
        numeros.add(25);
        numeros.add(32);
        numeros.add(4);

        for(int e:numeros){
            System.out.println(e);
        }

        System.out.println(" ");

        //ATV3
        System.out.println("ATV 3");
        
        ArrayList<String> jogos = new ArrayList<>();
        
        jogos.add("The Witcher 3");
        jogos.add("The Witcher 3");
        jogos.add("Dark souls 3");
        jogos.add("Dark souls 3");
        jogos.add("Dark Souls Remastered");
        jogos.add("Subnautica");
        jogos.add("COD Black ops 2");
        jogos.add("COD Black ops 2");

        ArrayList<String> duped = new ArrayList<>();

        for(int i=0;i<jogos.size();i++){
            if (!duped.contains(jogos.get(i))) {
                duped.add(jogos.get(i));
            }
        }

        System.out.println(duped);
        
        System.out.println(" ");
        
        //ATV4
        System.out.println("ATV 4");
        
        PriorityQueue<String> filmes = new PriorityQueue<>();

        filmes.add("DARK");
        filmes.add("Gambito da Rainha");
        filmes.add("Peaky BLinders");
        filmes.add("The Witcher");
        filmes.add("The Professional");

        System.out.println(filmes);

        System.out.println(" ");

        //ATV5
        System.out.println("ATV 5");
       
        HashMap<String, String> pecas = new HashMap<>();
      
        pecas.put("CPU","R7 5700g");
        pecas.put("GPU","RX 6650 XT");
        pecas.put("Placa Mãe","b450m Asus TUF gaming pro-s");
        pecas.put("RAM","Kingston FURY 2x8 DDR4");
        pecas.put("Fonte","Corsair RM750E");

        System.out.println(pecas);

    }
    
}
