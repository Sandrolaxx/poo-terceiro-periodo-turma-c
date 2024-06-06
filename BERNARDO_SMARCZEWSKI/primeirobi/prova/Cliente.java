package primeirobi.prova;

public class Cliente {
    
    private String nome;
    private String cpf;
    private Ingresso ingresso;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void verificarIngresso(int usuario, Evento evento) {
        if (this.ingresso != null) {
            if (this.ingresso.getEvento() == evento) {
                if (this.ingresso.isUse() == false) {
                    System.out.println(" Pode entrar no evento! ");
                    this.ingresso.setUso(true);
                } else {
                    System.out.println(" O ingresso ja foi utilizado! ");
                }
            } else {
                System.out.println(" Este ingresso não pode ser utilizado nesse evento! ");
            }
        } else {
            System.out.println(" O Cliente não possuí ingressos! ");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
}
