package PrimeiroB.Dona_Gabi.Myy_Plant;

public class Vendedor extends Pessoa {
    private Loja loja;
    private Double salarioBase;

    public Vendedor(String nome, Integer idade, Endereco endereco, Loja loja, Double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Loja: " + loja.getNomeFantasia()); // Adicionando apresentação da loja
    }
}