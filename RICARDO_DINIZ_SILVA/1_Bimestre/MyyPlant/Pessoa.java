package RICARDO_DINIZ_SILVA.MyyPlant;


public class Pessoa {
    public String nome;
    public int idade;
    public String cidade;
    public String bairro;
    public String rua;

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