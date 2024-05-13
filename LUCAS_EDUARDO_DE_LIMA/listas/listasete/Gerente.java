package LUCAS_EDUARDO_DE_LIMA.listas.listasete;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa {
   
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecibido = new ArrayList<>();

    public Gerente(String nome, Integer idade, Endereco endereco, Loja loja, double salarioBase, List<Double> salarioRecibido) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecibido = salarioRecibido;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void adicionarSalarioRecebido(double salarioum, double salariodois, double salariotres) {
        salarioRecibido.add(salarioum);
        salarioRecibido.add(salariodois);
        salarioRecibido.add(salariotres);
    }

    public void apresentarse() {
        System.out.println("Olá meu nome é " + nome + " tenho " + idade + " anos e trabalho na loja " + loja.getNomeFantasia());
    }

    public void calcularMedia() {
        double total = 0;
        for (Double valor : salarioRecibido) {
            total += valor;
        }
        double media = total / salarioRecibido.size();
        System.out.println("A media dos salarios é de: " + media);
    }

    public void calcularBonus() {
        System.out.println("Meu bonus de salário é: " + salarioBase * 0.35);
    }

    public Loja getLoja() {
        return loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<Double> getSalarioRecibido() {
        return salarioRecibido;
    }

    public void setSalarioRecibido(List<Double> salarioRecibido) {
        this.salarioRecibido = salarioRecibido;
    }
}
