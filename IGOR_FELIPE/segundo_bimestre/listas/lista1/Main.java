package segundo_bimestre.listas.lista1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static Map<String,String> registrarHardware(Map<String,String> hardwarePessoal){

        Scanner readHardware = new Scanner(System.in);

        System.out.println("Digite sua placa mãe: ");
        hardwarePessoal.put("placaMae",readHardware.nextLine());

        System.out.println("Digite seu processador: ");
        hardwarePessoal.put("processador",readHardware.nextLine());
        
        System.out.println("Digite sua placa de vídeo: ");
        hardwarePessoal.put("placaVideo",readHardware.nextLine());
        
        System.out.println("Digite sua fonte: ");
        hardwarePessoal.put("fonte",readHardware.nextLine());
        
        System.out.println("Digite sua memória RAM: ");
        hardwarePessoal.put("memoriaRam",readHardware.nextLine());

        readHardware.close();

        return hardwarePessoal;
    }

    public static ArrayList<String> listarJogos(ArrayList<String> jogosZerados){
        HashSet<String> jogosArrumados = new HashSet<>(); 
        
        jogosZerados.forEach(jogos -> jogosArrumados.add(jogos));

        jogosZerados.clear();

        jogosArrumados.forEach(jogos -> jogosZerados.add(jogos));
        
        return jogosZerados;
    };

    public static void main(String[] args) {

        //======== ATIVIDADE 1 ========
        ArrayList<String> nomesColegas = new ArrayList<>();

        nomesColegas.add("Gabriel Marcolin");
        nomesColegas.add("Arthur Tenório");
        nomesColegas.add("Maria Júlia");
        nomesColegas.add("Gabriel Paludo");
        nomesColegas.add("Giullia Vilanova");

        for(int i = 0;i<nomesColegas.size();i++){
            System.out.println("IG"+" - "+nomesColegas.get(i));
        }


        //======== ATIVIDADE 2 ========
        HashSet<Integer> numerosRepetidos = new HashSet<>();
        Scanner read = new Scanner(System.in);

        numerosRepetidos.add(5);
        numerosRepetidos.add(7);
        numerosRepetidos.add(6);
        numerosRepetidos.add(3);
        numerosRepetidos.add(5);
        numerosRepetidos.add(10);
        numerosRepetidos.add(3);
        numerosRepetidos.add(2);

        System.out.println("Digite um número para saber se está no Hash");
        int escolha = read.nextInt();
        
        if(numerosRepetidos.contains(escolha)){
            System.out.println("Esse número está no HashSet");
        }else{
            System.out.println("Esse número não está no HashSet");
        }

        //======== ATIVIDADE 3 ========

        ArrayList<String> jogosZerados = new ArrayList<>();

        jogosZerados.add("Celeste");
        jogosZerados.add("GTA V");
        jogosZerados.add("The Witcher 3");
        jogosZerados.add("Celeste");

        ArrayList<String> jogosZeradosArrumado = listarJogos(jogosZerados);
        
        System.out.println("--Jogos zerados--");

        for(String jogos : jogosZeradosArrumado){
            System.out.println(jogos);
        }

        System.out.println("");
        //======== ATIVIDADE 4 ========

        Queue<String> nomesAnimes = new PriorityQueue<>();
        
        nomesAnimes.add("One Piece");
        nomesAnimes.add("Attack on Titan");
        nomesAnimes.add("Kaguya-Sama");
        nomesAnimes.add("Naruto");
        nomesAnimes.add("Boku no Hero");

        nomesAnimes.forEach(animes -> System.out.println(animes));

        //======== ATIVIDADE 5 ========

        Map<String,String> hardwarePessoal = new HashMap<>();

        hardwarePessoal = registrarHardware(hardwarePessoal);

        System.out.println(hardwarePessoal.get("placaMae"));
        System.out.println(hardwarePessoal.get("processador"));
        System.out.println(hardwarePessoal.get("placaVideo"));
        System.out.println(hardwarePessoal.get("fonte"));
        System.out.println(hardwarePessoal.get("memoriaRam"));
        
        read.close();
    }
}
