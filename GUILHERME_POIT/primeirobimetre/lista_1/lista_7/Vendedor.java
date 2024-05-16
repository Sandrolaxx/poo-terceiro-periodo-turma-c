package primeirobimetre.lista_1.lista_7;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, Endereco endereco, Loja loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: " + getNome() + ", Idade: " + getIdade() + ", Loja: " + loja.getNomeFantasia());
    }

    public double calcularMedia() {
        double soma = 0;
        for (Double num : salarioRecebido) {
            soma += num;
        }
        return soma / salarioRecebido.size();
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

