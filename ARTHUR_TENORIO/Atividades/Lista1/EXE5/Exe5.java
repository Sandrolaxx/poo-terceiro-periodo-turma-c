import java.util.HashMap;
import java.util.Map;


public class Exe5 {
    public static void main(String[] args) {
        Exe5 exe5 = new Exe5();
        exe5.componentes();
    }

    public void componentes(){
        Map<String, String> peças = new HashMap<>();
        peças.put("Processdor: Ryzen 7 5700x ", "Valor: 1500,00");
        peças.put("Placa de Video: RTX 4060  ", "Valor: 2000,00");
        peças.put("Memoria RAM: 2 Pentes 16gb DDR4 ", "Valor: 400,00");
        peças.put("Placa MÃE: ASUS B550 GAMING ", "Valor: 1000,00");
        peças.put("Memoria: SSD 1TB", "Valor: 500,00");

        System.out.println(peças);
    }
}
