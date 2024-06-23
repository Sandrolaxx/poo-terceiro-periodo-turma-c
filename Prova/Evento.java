package Prova;


public class Evento {
    private String nome;
    private String local;
    private String data;
    private int ingressosDisponiveis;

    public Evento(String nome, String local, String data, int ingressosDisponiveis) {
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.ingressosDisponiveis = ingressosDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public String getData() {
        return data;
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public void venderIngresso(Cliente cliente) {
        if (ingressosDisponiveis > 0) {
            ingressosDisponiveis--;
            System.out.println("Ingresso vendido com sucesso para o evento: " + nome);
            System.out.println("Cliente: " + cliente.getNome());
        } else {
            System.out.println("Não há ingressos disponíveis para o evento: " + nome);
        }
    }

    @Override
    public String toString() {
        return "Nome do Evento: " + nome + ", Local: " + local + ", Data: " + data + ", Ingressos Disponíveis: " + ingressosDisponiveis;
    }
}