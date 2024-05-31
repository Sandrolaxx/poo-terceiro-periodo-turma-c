package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

public class Vendedor {
    double[] salarioR = new double[2];

    private String nome;
    
    private Double idade;

    private String loja;
    
    private String bairro;
    
    private String cidade;

    private String rua;

    private Double salarioB;

    private Double mediaSalarios;

    public Vendedor(String nome, Double idade, String loja, String bairro, String cidade, String rua,
            Double salarioB, double[] salarioR, Double mediaSalarios) {
        this.salarioR = salarioR;
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.salarioB = salarioB;
        this.mediaSalarios = mediaSalarios;
    }

    

    void apresentarse() {
        System.out.println("nome: " + String.valueOf(nome) + String.valueOf(", idade: ") + String.valueOf(idade) + String.valueOf(", loja: ") + String.valueOf(loja));
    }

    void calcularMedia() {
        mediaSalarios = (salarioR[0] + salarioR[1] + salarioR[2])/3;  
        System.out.println(mediaSalarios);
    }

   
    void calcularBonus() {
        double salarioR = salarioB * 0.2;
        System.out.println(salarioR);
    }

    public double[] getSalarioR() {
        return salarioR;
    }

    public String getNome() {
        return nome;
    }

    public Double getIdade() {
        return idade;
    }

    public String getLoja() {
        return loja;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public Double getSalarioB() {
        return salarioB;
    }

    public Double getMediaSalarios() {
        return mediaSalarios;
    }

    

}