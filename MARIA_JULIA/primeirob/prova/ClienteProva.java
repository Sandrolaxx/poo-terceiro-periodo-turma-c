package MARIA_JULIA.prova;

public class ClienteProva extends PessoaProva{
    
    private IngressoProva ingresso;
    

    public IngressoProva getIngresso() {
        return ingresso;
    }

    public void setIngresso(IngressoProva ingresso) {
        this.ingresso = ingresso;
    }

    public ClienteProva(String nome, int idade, String endereco) {
        super(nome, idade, endereco);
    }

    public void apresentarse() {
        String apresentar = "Cliente: " + getNome() + "\nIdade: " + getIdade();
        System.out.println(apresentar);
    }
}

