package primeirobi.lista05;

public class Vendedor {
    
    String nome;
    int idade;
    Loja loja;
    Endereco endereco;
    double salarioBase;
    double[] salarioRecebido;

    public Vendedor (String nome, int idade, Loja loja, double salarioBase, Endereco endereco) {

        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.endereco = endereco;
        this.salarioRecebido = new double[]{1800.00, 2100.00, 2500.00};;

    }

    public void apresentarse() {
        System.out.print("Sou o " + nome);
        System.out.print(", tenho " + idade);
        System.out.println(" anos e trabalho na " + loja.nome);
    }

    public double calcularMedia() {
        double soma = 0;
        for (int i = 0; i < salarioRecebido.length; i++) {
            soma = soma + salarioRecebido[i];
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

}