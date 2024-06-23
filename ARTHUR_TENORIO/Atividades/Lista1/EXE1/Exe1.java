import java.util.ArrayList;
import java.util.List;

public class Exe1 {
    public static void main(String[] args) {
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
        
    }

    
}
