package loja_myy_Plant;

import java.util.ArrayList;
//vendedor - cara q se fd
public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarinho;
    ArrayList<Double> salarionaConta = new ArrayList<>();

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salariodeprobre) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarinho = salariodeprobre;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarionaConta) {
            soma += salario;
        }
        return soma / salarionaConta.size();
    }

    public double calcularBonus() {
        return salarinho* 0.2;
    }
}