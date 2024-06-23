package bimestre_1.prova;
import java.util.Scanner;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade;
    private int ingressosVendidos;

    public Evento(String nome, String data, String local, int capacidade) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.ingressosVendidos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(int ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }

    public static Evento cadastrarNovoEvento(Scanner scanner) {
        System.out.println("Digite o nome do evento:");
        String nome = scanner.nextLine();
        System.out.println("Digite a data do evento:");
        String data = scanner.nextLine();
        System.out.println("Digite o local do evento:");
        String local = scanner.nextLine();
        System.out.println("Digite a capacidade de pessoas do evento:");
        int capacidade = Integer.parseInt(scanner.nextLine());

        return new Evento(nome, data, local, capacidade);
    }

   
    public void exibirDadosEvento() {
        System.out.println("Nome do evento: " + nome);
        System.out.println("Data do evento: " + data);
        System.out.println("Local do evento: " + local);
        System.out.println("Capacidade do evento: " + capacidade);
        System.out.println("Ingressos vendidos: " + ingressosVendidos);
    }
}

