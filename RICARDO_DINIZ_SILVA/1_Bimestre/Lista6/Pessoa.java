package RICARDO_DINIZ_SILVA.Lista6;

public class Pessoa extends Endereco {
    public String nome;
    public int idade;
    
    public Pessoa(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.println();
    }
}
