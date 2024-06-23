package primeirob.atividadeObjeto;

// 1. Crie um classe Gerente:
// - Com os atributos nome, idade, Loja, cidade, bairro, rua, salarioBase e salarioRecebido.
// - Atributo salarioRecebido DEVE armazenar no mínimo três valores de lançamentos de salário.(Pode colocar no código os valores*)
// - Métodos apresentarse calcularMedia e calcularBonus.
// - Método apresentarse deve printar o nome, idade e Loja.
// - calcularMedia deve trazer a média dos salários.
// - calcularBonus onde a fórmula é [salarioBase * 0.35].
public class Gerente extends Pessoa {

    private String loja;
    private double salarioBase;
    private double salarioRecebido[] = { 1000.00, 1002.00, 1082.00 };

    public String getLoja() {
        return loja;
    }


    public double getSalarioBase() {
        return salarioBase;
    }


    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }


    public Gerente(String nome, int idade, String estado, String cidade, String bairro, String rua, String loja, double salarioBase) {
        super(nome, idade, estado, cidade, bairro, rua);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }
    

    public void apresentarse() {
        String apresentar = "Vendedor: " + getNome() + "\nIdade: " + getIdade() + "\nLoja: " + getLoja();
        System.out.println(apresentar);

    }

    public void calcularMedia() {
        double media = 0;
        for (double i : getSalarioRecebido()) {
            media = media + i;
        }
        media = media / 3;
        System.out.println(media);

    }

    public void calcularBonus() {
        System.out.println(getSalarioBase() * 0.35);

    }
}
