
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.HashMap;

// Atv1 - Criar um ArrayList de strings e adicione os nomes de cinco dos seus colegas favoritos da turma. Em seguida, itere sobre a lista e imprima a inicial do seu nome + " - " + cada nome da lista.

public class atvUm {

    public static void main(String[] args) {

        ArrayList<String> coleguinhas = new ArrayList<>();

        coleguinhas.add("Rafael");
        coleguinhas.add("Guilherme");
        coleguinhas.add("Bernardo");
        coleguinhas.add("Kauê");
        coleguinhas.add("Anderson");

        for (String nome : coleguinhas) {
            char inicial = nome.charAt(0);
            System.out.println(inicial + "-" + nome);
        }
        System.out.println("\n--------\n");

        // Atv 2 - Crie um HashSet de números inteiros e adicione alguns números
        // repetidos. Verifique se o conjunto contém um número específico e imprima o
        // resultado.

        HashSet<Integer> numeros = new HashSet<>();

        numeros.add(23);
        numeros.add(12);
        numeros.add(10);
        numeros.add(4);
        numeros.add(23);

        int numeroEspecifico = 23;

        boolean contem = numeros.contains(numeroEspecifico);

        if (contem) {

            System.out.println("O conjunto de números contem o número " + numeroEspecifico);
        } else {
            System.out.println("O conjunto de números não contem o número especifico " + numeroEspecifico);
        }

        System.out.println("\n--------\n");

        // Atv3 - Escreva um método que receba uma lista de strings contendo os jogos
        // que você já zerou. Caso tenha zerado mais de uma vez, adicione o nome do jogo
        // para cada vez. Após criar a lista de jogos zerados, retorne uma nova lista
        // contendo apenas as strings únicas (sem duplicatas).

        List<String> jogosZerados = new ArrayList<>();

        jogosZerados.add("Gta V");
        jogosZerados.add("Gta San Andreas");
        jogosZerados.add("Call of Duty Blacck Ops");
        jogosZerados.add("Call of Duty Black Ops II");
        jogosZerados.add("Call of Duty Black Ops");

        List<String> jogosUnicos = getJogosUnicos(jogosZerados);

        for (String jogo : jogosUnicos) {
            System.out.println(jogo);
        }

        System.out.println("\n--------\n");

        // Atv4 -Crie um método que utilize PriorityQueue para ordenar uma lista com o
        // nome dos cinco melhores animes/filmes que você já viu em ordem alfabética. Em
        // seguida, imprima a lista ordenada.
        String[] melhoresAnimesFilmes = {

                "Naruto",
                "Naruto Shippuden",
                "Baki",
                "X hunter",
                "The Last Naruto"
        };

        ordernarEImprimir(melhoresAnimesFilmes);

        imprimirConfiguracoesHardware();

    }

    // Metodo atv3
    public static List<String> getJogosUnicos(List<String> jogoZerados) {

        HashSet<String> setUnico = new HashSet<>(jogoZerados);

        return new ArrayList<>(setUnico);
    }

    // Metodo atv 4
    public static void ordernarEImprimir(String[] animesFilmes) {

        PriorityQueue<String> filaPrioridade = new PriorityQueue<>();

        for (String nome : animesFilmes) {
            filaPrioridade.add(nome);
        }

        System.out.println("Lista ordenada de animes e filmes:");
        while (!filaPrioridade.isEmpty()) {
            System.out.println(filaPrioridade.poll());
        }

        System.out.println("\n------\n");

        // Atv5 -Crie um método que crie uma estrutura que permita salvar as
        // configurações de hardware da sua máquina, exemplo: "Processador" : "i5
        // 7500U". Faça isso para no mínimo 5 peças e imprima a peça e seu respectivo
        // valor.


    }

    public static void imprimirConfiguracoesHardware() {
        
        HashMap<String, String> configuracoesHardware = new HashMap<>();

        configuracoesHardware.put("Processador", "AMD Ryzen 5 5600G");
        configuracoesHardware.put("Memória RAM", "16GB DDR4 XPG");
        configuracoesHardware.put("Placa de Vídeo", "NVIDIA GTX 3060");
        configuracoesHardware.put("Armazenamento", "500GB SSD");
        configuracoesHardware.put("Placa Mãe", "Tuf Gaming B550M");


        for (Entry<String, String> entry : configuracoesHardware.entrySet()){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        System.out.println("\n------");
    }

}