package lista_6;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>();

    public Gerente(String nome, int idade, Endereco endereco, Loja loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia());
    }

    public double calcularMedia() {
        double soma = 0;
        for (Double num : salarioRecebido) {
            soma += num;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase *= 0.35;
    }

    public void adicionarSalarioRecebido(double salario) {
        salarioRecebido.add(salario);
    }

}
