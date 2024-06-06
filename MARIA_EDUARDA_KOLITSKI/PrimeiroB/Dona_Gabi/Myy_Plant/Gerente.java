package PrimeiroB.Dona_Gabi.Myy_Plant;

public class Gerente extends Pessoa {
    private String loja;
    private Double salarioBase;
    private Double[] salarioRecebido = new Double[3];

    public Gerente(String nome, Integer idade, String loja, Double salarioBase, Double[] salarioRecebido) {
        super(nome, idade, null);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Loja: " + loja);
    }

    public Double calcularMedia() {
        Double somaSalarios = 0d;
        for (Double salario : salarioRecebido) {
            somaSalarios += salario;
        }
        return somaSalarios / salarioRecebido.length;
    }

    public Double calcularBonus() {
        return salarioBase * 0.35;
    }
}