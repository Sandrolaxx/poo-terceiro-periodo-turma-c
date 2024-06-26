package ANDERSON_TESSARO.prova;

class Participante {
    private String nome;
    private String cpf;
    private boolean ingressoComprado;
    private boolean ingressoUtilizado;
    private Evento evento;

    public Participante(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.ingressoComprado = false;
        this.ingressoUtilizado = false;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isIngressoComprado() {
        return ingressoComprado;
    }

    public boolean isIngressoUtilizado() {
        return ingressoUtilizado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void comprarIngresso() {
        this.ingressoComprado = true;
    }

    public void utilizarIngresso() {
        if (ingressoComprado &&!ingressoUtilizado) {
            this.ingressoUtilizado = true;
        } else {
            System.out.println("Ingresso não comprado ou já utilizado.");
        }
    }
}