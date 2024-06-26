public class Evento {

    private String nome;
    private String descricao;
    private LocalDate data;
    private double valorIngresso;
    private int ingressosDisponiveis;

    public Evento(String nome, String descricao, LocalDate data, double valorIngresso) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.ingressosDisponiveis = 0; 
    }

    public void venderIngresso() {
        if (ingressosDisponiveis > 0) {
            ingressosDisponiveis--;
        } else {
            System.out.println("Evento esgotado!");
        }
    }

    public boolean verificarIngressosDisponiveis() {
        return ingressosDisponiveis > 0;
    }
}
