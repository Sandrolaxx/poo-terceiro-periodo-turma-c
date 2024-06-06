
import java.util.Set;
import java.util.HashSet;
public class Exe2 {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
      

        for (Integer numero : numeros ){
            if (numero == 1){
                System.out.println("Numero 1 existe na lista ");
            }
        }
        
    }

    
}
