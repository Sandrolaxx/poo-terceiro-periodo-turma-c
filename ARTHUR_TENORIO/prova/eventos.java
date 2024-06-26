package ARTHUR_TENORIO.prova;

public class eventos {

    private String nome;
    private String data;
    private String hora;
    private String local;
    private String descricao;
    private double valorIngresso;
    private int quantidadeIngressosDisponiveis;

    public eventos(String nome, String data, String hora, String local, String descricao, double valorIngresso) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.descricao = descricao;
        this.valorIngresso = valorIngresso;
        this.quantidadeIngressosDisponiveis = 0; 
    }


    public void setQuantidadeIngressosDisponiveis(int quantidadeIngressosDisponiveis) {
        this.quantidadeIngressosDisponiveis = quantidadeIngressosDisponiveis;
    }

    public int getQuantidadeIngressosDisponiveis() {
        return quantidadeIngressosDisponiveis;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", local='" + local + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valorIngresso=" + valorIngresso +
                ", quantidadeIngressosDisponiveis=" + quantidadeIngressosDisponiveis +
                '}';
    }
}