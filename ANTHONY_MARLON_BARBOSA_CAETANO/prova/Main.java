package ANTHONY_MARLON_BARBOSA_CAETANO.prova;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "joao@gmail.com");
        Cliente cliente2 = new Cliente("Maria", "maria@gmail.com");
        
        Evento evento1 = new Evento("Concerto", "25/04/2024", 50.0);
        Evento evento2 = new Evento("Festival", "01/05/2024", 100.0);
        
        Ingresso ingresso1 = new Ingresso(evento1, cliente1);
        
        List<Evento> eventos = new ArrayList<>();
        eventos.add(evento1);
        eventos.add(evento2);
        
        System.out.println("Eventos disponíveis:");
        for (Evento evento : eventos) {
            System.out.println("Nome: " + evento.getNome() + ", Data: " + evento.getData() + ", Preço: " + evento.getPreco());
        }
        
        System.out.println("\nCompra de ingresso:");
        System.out.println("Ingresso para " + ingresso1.getEvento().getNome() + " comprado por " + ingresso1.getCliente().getNome());
        
        ingresso1.utilizarIngresso();
        System.out.println("\nUtilização de ingresso:");
        System.out.println("Ingresso para " + ingresso1.getEvento().getNome() + " utilizado? " + (ingresso1.isUtilizado() ? "Sim" : "Não"));
    }
}
