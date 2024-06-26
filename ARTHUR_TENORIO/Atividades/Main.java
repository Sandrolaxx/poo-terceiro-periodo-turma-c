import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Atividade 1

        System.out.println("Atividade 1 ");
        System.out.println("-----------------------------------------------------------");
        List<String> names = new ArrayList<String>();
        names.add("Sandro");
        names.add("Sandrinho");
        names.add("Sandrolax");
        names.add("Professor Sandro");
        names.add("Mestre Sandro");

        for (String name : names ){
            char primeira = name.charAt(0);
            System.out.println(primeira + " - " + name );
        }
        
        // Atividade 2
        System.out.println("Atividade 2 ");
        System.out.println("-----------------------------------------------------------");
        Set<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
 
        for (Integer numero : numeros ){
            if (numero == 1){
                System.out.println("Numero 1 existe na lista ");
            }
        }
        
        System.out.println("Atividade 3 ");
        System.out.println("-----------------------------------------------------------");
        // Atividade 3
        List<String> jogos = jogosZerados();
        System.out.println("Lista de Jogos Zerados: ");
        System.out.println(jogos);


        System.out.println("Atividade 4 ");
        System.out.println("-----------------------------------------------------------");
        // Atividade 4
        Queue<String> melhoresFilmes = filmes();
        System.out.println("Lista ordenada de filmes:");
        while (!melhoresFilmes.isEmpty()) {
            System.out.println(melhoresFilmes.poll());
        }

        // Atividade 5

        System.out.println("Atividade 5 ");
        System.out.println("-----------------------------------------------------------");
        Map<String, String> peças = componentes();
        System.out.println(peças);
    }

    // Atividade 3
    public static List<String> jogosZerados() {
        List<String> games = new ArrayList<String>();
        games.add("Spider-Man");
        games.add("Call of Duty BO II");
        games.add("Lego Star Wars 2");
        games.add("Lego Star Wars 2");

        Set<String> unicos = new HashSet<>(games);

        return new ArrayList<>(unicos);
    }

    // Atividade 4
    public static Queue<String> filmes(){
        Queue<String> melhoresFilmes = new PriorityQueue<>();
        melhoresFilmes.add("One Piece");
        melhoresFilmes.add("Attack On Titan");
        melhoresFilmes.add("Perdido em Marte ");
        melhoresFilmes.add("Esposa de mentirinha");
        melhoresFilmes.add("Sword Art Online");

        return melhoresFilmes;
    }

    // Atividade 5
    public static Map<String, String> componentes(){
        Map<String, String> peças = new HashMap<>();
        peças.put("Processdor: Ryzen 7 5700x ", "Valor: 1500,00");
        peças.put("Placa de Video: RTX 4060  ", "Valor: 2000,00");
        peças.put("Memoria RAM: 2 Pentes 16gb DDR4 ", "Valor: 400,00");
        peças.put("Placa MÃE: ASUS B550 GAMING ", "Valor: 1000,00");
        peças.put("Memoria: SSD 1TB", "Valor: 500,00");

        return peças;
    }
}
