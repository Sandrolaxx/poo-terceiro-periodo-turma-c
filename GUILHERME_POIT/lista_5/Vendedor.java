package lista_5;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, String cidade, String bairro, String rua, Loja loja, double salarioBase) {
        super(nome, idade, cidade, bairro, rua);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }


    public double calcularMedia() {
        double soma = 0;
        for (Double num : salarioRecebido) {
            soma += num;
        }
        return soma / salarioRecebido.size();
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia());
    }


    public double calcularBonus() {
        return salarioBase *= 0.2;
    }

    public void adicionarSalarioRecebido(double salario) {
        salarioRecebido.add(salario);
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}

