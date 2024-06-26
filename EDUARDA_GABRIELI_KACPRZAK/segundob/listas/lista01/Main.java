package listas.lista01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {

    Scanner scan = new Scanner(System.in);
    public static ArrayList<String> listarJogos(ArrayList<String> jogosZerados){
        HashSet<String> jogosArrumados = new HashSet<>(); 

        jogosZerados.forEach(jogos -> jogosArrumados.add(jogos));

        jogosZerados.clear();

        jogosArrumados.forEach(jogos -> jogosZerados.add(jogos));

        return jogosZerados;
    };

    public static void main(String[] args) {

        // -------------- ATIVIDADE 01 ----------------

        ArrayList<String> namesFav = new ArrayList<>();

        namesFav.add("Giullia Ortiz");
        namesFav.add("Maria Kolistki");
        namesFav.add("Rafael Roani");
        namesFav.add("Maria Clara");
        namesFav.add("Isabela Leandro"); // .add adiciona um novo item no arraylist

        for(int i = 0; i < namesFav.size(); i++){
            System.out.println("EG" + " - " + namesFav.get(i));
        }


        // -------------- ATIVIDADE 02 ----------------

        System.out.println("\n");
        HashSet<Integer> numerosRepetidos = new HashSet<>();
        Scanner scan = new Scanner(System.in);
    
        numerosRepetidos.add(1);
        numerosRepetidos.add(2);
        numerosRepetidos.add(3);
        numerosRepetidos.add(4);
        numerosRepetidos.add(5);
        numerosRepetidos.add(6);
        numerosRepetidos.add(7);
        numerosRepetidos.add(8);
        numerosRepetidos.add(9);
        numerosRepetidos.add(10);
        numerosRepetidos.add(10);
    
        System.out.println("Digite um número: ");
        int num = scan.nextInt();
    
        if (numerosRepetidos.contains(num)) {
            System.out.println("Esse número foi adicionado!");
        } else {
            System.out.println("Esse número não foi adicionado!");
            System.out.println("\n");
        }
     
     // -------------- ATIVIDADE 03 ----------------

     ArrayList<String> jogosZerados = new ArrayList<>();
    
     System.out.println("\n");
     jogosZerados.add("The Witcher 3");
     jogosZerados.add("Red Dead Redemption 2");
     jogosZerados.add("Horizon Zero Dawn");
     jogosZerados.add("God Of War");

     ArrayList<String> newJogosZerados = listarJogos(jogosZerados);

     System.out.println("Jogos que zerei: ");

     for(String jogos : newJogosZerados){
         System.out.println(jogos);
     }

    // -------------- ATIVIDADE 04 ----------------

    Queue<String> nomesAnimes = new PriorityQueue<>();

    System.out.println("\n");
    nomesAnimes.add("Sousou no Frieren");
    nomesAnimes.add("Haikyuu");
    nomesAnimes.add("Lycoris Recoil");
    nomesAnimes.add("Violet Evergarden");
    nomesAnimes.add("Kaguya-sama");
    
    nomesAnimes.forEach(animes -> System.out.println(animes));

           
    // -------------- ATIVIDADE 05 ----------------

      Map<String, String> configuracoes = new HashMap<>();

      System.out.println("\n");
      configuracoes.put("Processador", "i5 7500U");
      configuracoes.put("Memória RAM", "8 GB");
      configuracoes.put("Placa de Vídeo", "Intel HD Graphics 620");
      configuracoes.put("Armazenamento", "SSD 256 GB");
      configuracoes.put("Sistema Operacional", "Windows 10 Pro");

      System.out.println("Configurações de Hardware:");
      for (Map.Entry<String, String> configuracao : configuracoes.entrySet()) {
          System.out.println(configuracao.getKey() + ": " + configuracao.getValue());
      }
  
    }    
}
