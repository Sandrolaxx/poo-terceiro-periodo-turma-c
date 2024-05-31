package MARCELO_PILUSKI_POZZOBON.prova.src;

import java.util.Date;
import java.util.Scanner;

public class Evento {
    private int[] id = new int[99];
    private Scanner nomeScanner = new Scanner(System.in);
    public String[] nome = new String[99];
    private Scanner localScanner = new Scanner(System.in);
    public String[] local = new String[99];
    private Date data = new Date(); // 86400000 é 1 dia em milissegundos
    public Long dataExtenso;
    public String[] dataEvento = new String[99];

    public void cadastrarEvento() {
        for (int i = 0; i <= id.length - 1; i++) {
            if (id[i] == 0 && nome[i] == null) {
                id[i] = i;
                System.out.print("Nome: ");
                nome[i] = nomeScanner.next();
                System.out.print("Local [Rua e Número apenas]: ");
                local[i] = localScanner.next();
                dataExtenso = data.getTime();
                dataEvento[i] = dataExtenso.toString();
                System.out.println("Data de criação: " + dataEvento);
                break;
            }
        }

    }

    public void listarEventos() { // terminar
        for (int i = 0; i <= id.length - 1; i++) {
            if (id[i] == 0 && nome[i] == null) {
                break;
            }
            System.out.println("{Id: " + id[i] + "\nEvento: " + nome[i] + "\nData do Evento: " + dataEvento[i] + "}");
        }

    }

    public int[] getId() {
        return id;
    }

}
