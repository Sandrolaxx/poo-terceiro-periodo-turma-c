package bimestre_1.atividade_5;

public class Vendedor {
    private String name;
    private int age;
    private String store;
    private String city;
    private String neighborhood;
    private String street;
    private double wageB;
    private double[] wageR;

    public Vendedor(String name, int age, String store, String city, String neighborhood, String street, double wageB, double[] wageR) {
        this.name = name;
        this.age = age;
        this.store = store;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.wageB = wageB;
        this.wageR = wageR;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + name);
        System.out.println("Idade: " + age);
        System.out.println("Loja: " + store);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : wageR) {
            soma += salario;
        }
        return soma / wageR.length;
    }

    public double calcularBonus() {
        return wageB * 0.2;
    }
}



  

