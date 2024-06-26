package RICARDO_DINIZ_SILVA.Lista6;

public class Vendedor extends Pessoa{
    Loja loja;
    double salarioBase;
    double[] salariosRecebidos;

    public Vendedor(String nome, int idade, String cidade, String bairro, String rua, double salarioBase, double[] salariosRecebidos) {
        super(nome, idade, cidade, bairro, rua);
        this.salarioBase = salarioBase;
        this.salariosRecebidos = salariosRecebidos;
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: ".concat(nome).concat(", minha idade: ").concat(String.valueOf(idade)).concat(", loja: ".concat(loja.nomeFantasia)));
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public double calcularMedia() {
        double soma = 0;
        for(double salario : salariosRecebidos) {
            soma += salario;
        }
        return soma / salariosRecebidos.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
