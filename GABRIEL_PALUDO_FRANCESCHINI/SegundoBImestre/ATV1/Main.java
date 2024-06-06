import java.util.*;

public class Main {
      public static void main(String[] args) {
            System.out.println("Atividade 1:");
            atv1();
            System.out.println("\nAtividade 2:");
            atv2();
            System.out.println("\nAtividade 3:");
            atv3();
            System.out.println("\nAtividade 4:");
            atv4();
            System.out.println("\nAtividade 5:");
            atv5();
      }



      //ATV1     
      public static void atv1() {
            ArrayList<String> amigos = new ArrayList<>();
            amigos.add("Marcelo");
            amigos.add("Gonçalves");
            amigos.add("Luiz");
            amigos.add("Sandro");
            amigos.add("Sandrolaxx");

            System.out.println("Miguxos:");
            for (String nome : amigos) {
            System.out.println(nome.charAt(0) + " - " + amigos);
            }
      }



      //ATV2
      public static void atv2() {
            HashSet<Integer> numerosInt = new HashSet<>();
            numerosInt.add(1);
            numerosInt.add(2);
            numerosInt.add(3);
            numerosInt.add(4);
            numerosInt.add(5);
            int numeroVerificar = 3;

            System.out.println("O número " + numeroVerificar + " está na lista? " + numerosInt.contains(numeroVerificar));
      }

      //ATV3

      public static void atv3() {

            ArrayList<String> jogosZerados = new ArrayList<>();
    
            jogosZerados.add("Minecraft");
            jogosZerados.add("Minecraft");
            jogosZerados.add("Minecraft");
            jogosZerados.add("Super Mario World");
            jogosZerados.add("Super Mario World");
            jogosZerados.add("Sonic");

            System.out.println("Jogos zerados:");
            jogosZerados.stream().distinct().forEach(game -> System.out.println(game));
      }



      //ATV4
      public static void atv4() {
            Queue<String> seriesFilmes = new PriorityQueue<>();

            System.out.println("Filmes/séries em ordem alfabética:");
            seriesFilmes.add("Drive my car");
            seriesFilmes.add("Oldboy");
            seriesFilmes.add("The Sopranos");
            seriesFilmes.add("Mr. Robot");
            seriesFilmes.add("Breaking Bad");

            seriesFilmes.forEach(filmeserie -> System.out.println(filmeserie));
      }



      //ATV5
      public static void atv5() {
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;
            ArrayList<String> CPU = new ArrayList<>();

            ArrayList<String> GPU = new ArrayList<>();

            while (continuar) {
                  System.out.println("Escolha uma opção");
                  System.out.println("[1] - Adicionar Processador");
                  System.out.println("[2] - Adicionar Placa de Vídeo");
                  System.out.println("[3] - Apresentar peças");
                  int calculator = scanner.nextInt();
            
                  switch (calculator) {
                  case 1:
                  System.out.println("Escreva o nome do processador");
                  scanner.nextLine();
                  CPU.add(scanner.nextLine());
                  break;
                  case 2:
                  System.out.println("Escreva o nome da placa de vídeo");
                  scanner.nextLine();
                  GPU.add(scanner.nextLine());
                  break;
                  case 3:
                        System.out.println("Processadores:");
                        for (String processador : CPU) {
                              System.out.println(processador);
                        }
                        System.out.println("Placas de Vídeo:");
                        for (String placaVideo : GPU) {
                              System.out.println(placaVideo);
                        }
                        scanner.close();
                        continuar = false;
                        break;
                  }
            } 
      }
}