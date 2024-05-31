package segundobi.lista01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {


        // ATV 01

        ArrayList<String> colegas = new ArrayList<>();

        colegas.add("Guilherme");
        colegas.add("Rafael");
        colegas.add("Andeshow");
        colegas.add("Lucas");
        colegas.add("Kaue");

        for (String nome : colegas) {
            System.out.println(nome.charAt(0) + " - " + nome);
        }

        System.out.println();


        // ATV 02

        HashSet<Integer> numeros = new HashSet<>();

        numeros.add(3);
        numeros.add(4);
        numeros.add(0);
        numeros.add(4);
        numeros.add(2);
        numeros.add(5);

        int verificar = 0;
        if (numeros.contains(verificar)) {
            System.out.println("O número " + verificar + " está no HashSet");
        } else {
            System.out.println("O número " + verificar + " NÃO está no HashSet");
        }

        System.out.println();


        // ATV 03

        ArrayList<String> jogosZerados = new ArrayList<>();

        jogosZerados.add("Far Cry 4");
        jogosZerados.add("Uncharted");
        jogosZerados.add("Batman Arkham");
        jogosZerados.add("Assassins Creed Odyssey");
        jogosZerados.add("Pokemon Emerald");
        jogosZerados.add("Far Cry 4");
        jogosZerados.add("BioShock");

        HashSet<String> jogosSemRepetir = Main.removerJogos(jogosZerados);

        for (String jogo : jogosSemRepetir) {
            System.out.println(jogo);
        }

        System.out.println();


        // ATV 04

        ArrayList<String> melhoresFilmes = new ArrayList<>();

        melhoresFilmes.add("The Batman");
        melhoresFilmes.add("Bastardos Inglorios");
        melhoresFilmes.add("Os Infiltrados");
        melhoresFilmes.add("Polp Fiction");
        melhoresFilmes.add("Django Livre");

        PriorityQueue<String> filmesOrdenados = Main.ordenar(melhoresFilmes);

        for (String filme : filmesOrdenados) {
            System.out.println(filme);
        }

        System.out.println();


        // ATV 05

        HashMap<String, String> hardware = new HashMap<>();

        hardware.put("Sistema Operacional", "Windows 10");
        hardware.put("Processador", "intel CORE i5");
        hardware.put("Memória RAM", "16GB");
        hardware.put("Placa de Vídeo", "NVIDIA GeForce GTX");
        hardware.put("Armazenamento", "SSD 512GB");


        Main.imprimirHardware(hardware);

    }

    // ATV 03
    public static HashSet<String> removerJogos(ArrayList<String> array) {

        HashSet<String> jogos = new HashSet<>(array);
        return jogos;
        
    }

    // ATV 04
    public static PriorityQueue<String> ordenar(ArrayList<String> array) {
        
        PriorityQueue<String> filmes = new PriorityQueue<>(array);
        return filmes;

    }

    // ATV 05
    public static void imprimirHardware(HashMap<String, String> hardware) {

        for (HashMap.Entry<String, String> entry : hardware.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

}

