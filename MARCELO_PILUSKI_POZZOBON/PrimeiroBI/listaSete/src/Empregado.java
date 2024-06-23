package listaSete.src;

public class Empregado {
    public int id;
    public String nome;
    public int idade;
    public String nomeLoja = new Loja().nome;
    public Double salarioBase;
    public Double[] salarioRecebido = new Double[99];
    public Double[] bonusMensal = new Double[99];
    public Endereco endereco = new Endereco();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Olá, eu sou o " + this.nome + ", e tenho " + idade + " anos de idade.");
    }
}
