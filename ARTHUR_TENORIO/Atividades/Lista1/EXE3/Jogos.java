
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


public class Jogos {
    public ArrayList<String> Jogoszerados() {
    List<String> games = new ArrayList<String>();
    games.add("Spider-Man");
    games.add("Call of Duty BO II");
    games.add("Lego Star Wars 2");
    games.add("Lego Star Wars 2");

    Set<String> unicos = new HashSet<>(games);

    return new ArrayList<>(unicos);

    }

    public static void main(String[] args) {
        Jogos jogos = new Jogos();
        List <String> JogosUnicos = jogos.Jogoszerados();
        System.out.println("Lista de Jogos Zerados: ");
        System.out.println(JogosUnicos);
    }
}
