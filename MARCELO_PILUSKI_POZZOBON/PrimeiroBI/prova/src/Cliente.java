package MARCELO_PILUSKI_POZZOBON.prova.src;
import java.util.Scanner;

public class Cliente {
    private int[] id = new int[99];
    private Scanner nomeScanner = new Scanner(System.in);
    public String[] nome = new String[99];
    private Scanner idadeScanner = new Scanner(System.in);
    public int idade;
    public Ingresso[] ingressos = new Ingresso[99];
    public int[] idIngressos = new int[99];
    public Scanner ingressosScanner = new Scanner(System.in);

    public Scanner scan = new Scanner(System.in);

    public void cadastrarCliente() {
        for (int i = 0; i <= id.length - 1; i++) {
            if (id[i] == 0 && nome[i] == null) {
                id[i] = i;
                System.out.print("Nome: ");
                nome[i] = nomeScanner.next();
                System.out.print("Idade: ");
                idade = idadeScanner.nextInt();
                break;
            }
        }

    }

    public void mostrarClientes() {
        for (int i = 0; i <= id.length - 1; i++) {
            if (id[i] == 0 && nome[i] == null) {
                break;
            }
            System.out.println("{Id: " + id + "Nome: " + nome + "Idade: " + idade + "}");
        }
    }

    public void utilizarIngresso() {
        int idFuncao;

        mostrarClientes();
        System.out.print("Qual cliente? [identifique pelo id]: ");
        idFuncao = scan.nextInt();
        idIngressos[idFuncao] = 0;
        System.out.println("Ingresso usado com sucesso!");
    }

    public int[] getId() {
        return id;
    }
}
