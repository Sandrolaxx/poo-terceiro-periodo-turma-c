package bimestre_1.atividade_6;

public class Vendedor {
    private String name;
    private int age;
    private String store;
   public Endereco endereco;
    private float wageB;
    private float[] wageR;

    public Vendedor(String name, int age, String store, float wageB, float[] wageR, String state, String city, String neighborhood, String number, String complement) {
        this.name = name;
        this.age = age;
        this.store = store;
        this.wageB = wageB;
        this.wageR = wageR;
        this.endereco = new Endereco(state, city, neighborhood, number, complement);
    }

    public void apresentarSe() {
        System.out.println("Nome: " + name);
        System.out.println("Idade: " + age);
        System.out.println("Loja: " + store);
    
    }

    public float calcularMedia() {
        float soma = 0;
        for (float salario : wageR) {
            soma += salario;
        }
        return soma / wageR.length;
    }
    
    public float calcularBonus() {
        return wageB * 2;
    }
}
