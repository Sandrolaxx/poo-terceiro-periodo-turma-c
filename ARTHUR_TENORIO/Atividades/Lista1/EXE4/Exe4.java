
import java.util.PriorityQueue;
import java.util.Queue;


public class Exe4 {

    public static void main(String[] args) {
        Exe4 exe4 = new Exe4();
        exe4.filmes();
    }
    
    public void filmes(){
        Queue<String> melhoresFilmes = new PriorityQueue<>();
        melhoresFilmes.add("One Piece");
        melhoresFilmes.add("Attack On Titan");
        melhoresFilmes.add("Perdido em Marte ");
        melhoresFilmes.add("Esposa de mentirinha");
        melhoresFilmes.add("Sword Art Online");

        System.out.println("Lista ordenada de filmes:");
        while (!melhoresFilmes.isEmpty()) {
            System.out.println(melhoresFilmes.poll());
        }

    }
   
}
