package segundob.listas.lista1;
import java.util.ArrayList; // import the ArrayList class
import java.util.HashMap;
import java.util.HashSet; // Import the HashSet class
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
public class Main {
    
    public static  Set<String>  retornaJogosLimpos(ArrayList<String> jogos) {
        //atv3
        // Atv3 - Escreva um método que receba uma lista de strings contendo os jogos que você já zerou. Caso tenha zerado mais de uma vez, adicione o nome do jogo para cada vez. Após criar a lista de jogos zerados, retorne uma nova lista contendo apenas as strings únicas (sem duplicatas).
        Set<String> jogosLimpos = new HashSet<String>(); 
        for (String jogo : jogos) {
            jogosLimpos.add(jogo);
          } 

       return jogosLimpos;
    }

    public static PriorityQueue<String>  retornaAnimesOrdemAlfabetica(ArrayList<String> animes) {
        // Atv4 -Crie um método que utilize PriorityQueue para ordenar uma lista com o nome dos cinco melhores animes/filmes que você já viu em ordem alfabética. Em seguida, imprima a lista ordenada.
        PriorityQueue<String> animeOrdem = new PriorityQueue<String>();
        for (String anime : animes) {
            animeOrdem.add(anime);
        } 
        return animeOrdem;

        
    }
    public static Map<String,String> retornaHardwareConfigurado(Map<String,String> hardware, String nome, String config){
        // Atv5 -Crie um método que crie uma estrutura que permita salvar as configurações de hardware da sua máquina, exemplo: "Processador" : "i5 7500U". Faça isso para no mínimo 5 peças e imprima a peça e seu respectivo valor.
        hardware.put(nome,config);
        return hardware;
    }
    public static void main(String[] args) {
        System.out.println("ATIVIDADE 1 ---------------------------");
        // atv1
        // Atv1 - Criar um ArrayList de strings e adicione os nomes de cinco dos seus colegas favoritos da turma. Em seguida, itere sobre a lista e imprima a inicial do seu nome + " - " + cada nome da lista.
        ArrayList<String> colegas = new ArrayList<String>();
        colegas.add("Arthur");
        colegas.add("Igor");
        colegas.add("Marcolin");
        colegas.add("Kaue");
        colegas.add("GP");
        colegas.add("Marcelo");
        // interpretei "seu nome" como meu nome, e nao como o nome de cada colega
        for (String nome : colegas) {
            System.out.println("MJ - " + nome);
          }


        System.out.println("ATIVIDADE 2 ---------------------------");
        // atv2
        // Atv2 - Crie um HashSet de números inteiros e adicione alguns números repetidos. Verifique se o conjunto contém um número específico e imprima o resultado.
        HashSet<Integer> numeros = new HashSet<Integer>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        
        // repetidos
        numeros.add(1);
        numeros.add(3);
        numeros.add(5);

        for(int numero : numeros) {
            System.out.println(numero);
          }
        

        System.out.println("ATIVIDADE 3 ---------------------------");          
        //atv 3 testando
        ArrayList<String> jogos = new ArrayList<String>();

        jogos.add("Call of Duty - Black ops 2");
        jogos.add("Plants vs Zombies");
        jogos.add("Crash Bandicoot");

        jogos.add("Call of Duty - Black ops 2");
        jogos.add("Plants vs Zombies");

        Set<String> jogosTeste = retornaJogosLimpos(jogos);

        for (String jogo : jogosTeste) {
            System.out.println(jogo);
        }


        System.out.println("ATIVIDADE 4 ---------------------------");
        //atv 4 testando
        ArrayList<String> animes = new ArrayList<String>();

        animes.add("Kamisama Hajimemashita");
        animes.add("Naruto");
        animes.add("K-on");
        animes.add("Akagami no Shirayuki-hime");
        animes.add("Fullmetal brotherhood");
        PriorityQueue<String> animesTeste = retornaAnimesOrdemAlfabetica(animes);

        for (String anime : animesTeste) {
            System.out.println(anime);
        }


        System.out.println("ATIVIDADE 5 ---------------------------");
        Scanner scanner = new Scanner(System.in); // Crie um objeto Scanner para ler a entrada do usuário
        Map<String,String> hardwareConfigurado = new HashMap<>();


        for (int i = 0; i <= 5; i++) {
            System.out.println("VAMOS INSERIR AS CONFIGURACOES -----");
            System.out.println("Nome do hardware: ");
            String nomeHardware = scanner.nextLine();
            System.out.println("Configuração do hardware: ");
            String configuracaoHardware = scanner.nextLine();
            hardwareConfigurado = retornaHardwareConfigurado(hardwareConfigurado, nomeHardware,configuracaoHardware);

        }
        System.out.println("print ---------------");
        for (Map.Entry<String, String> entry : hardwareConfigurado.entrySet()) {
            String chave = entry.getKey();
            String valor = entry.getValue();
            System.out.println("Nome do hardware: " + chave + ", \nConfiguração: " + valor);

        }

    }
  

}
