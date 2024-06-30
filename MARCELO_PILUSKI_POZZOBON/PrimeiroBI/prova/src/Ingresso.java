package MARCELO_PILUSKI_POZZOBON.prova.src;

import java.util.Date;
import java.util.Scanner;

public class Ingresso {
    private int[] id = new int[99];
    private Date dataIngresso = new Date(); // 86400000 é 1 dia em milissegundos
    public Long dataCompra = dataIngresso.getTime();
    public Evento eventoIngresso = new Evento();
    public Scanner idEventoScanner = new Scanner(System.in);
    public int idEvento;
    private Cliente cliente = new Cliente();
    private Scanner clienteScanner = new Scanner(System.in);
    
    public void comprarIngresso() {
        int idCliente;

        System.out.println("Eventos:");
        for (int i = 0; i <= eventoIngresso.getId().length - 1; i++) {
            if (eventoIngresso.getId()[i] == 0 && eventoIngresso.nome[i] == null) {
                break;
            }
            System.out.println("  " + i +" " + eventoIngresso.nome);
        }
        System.out.print("Qual evento? [identifique pelo id]: ");
        idEvento = idEventoScanner.nextInt();
        cliente.mostrarClientes();
        System.out.print("Qual cliente? [identifique pelo id]: ");
        idCliente = clienteScanner.nextInt();
        
        for (int i = 0; i <= cliente.getId().length; i++) {
            if (idCliente == i) {
                cliente.idIngressos[i] = id[i];
            }
        }
    }

    public int[] getId() {
        return id;
    }
}
