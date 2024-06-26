package Listasete;

public class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private float[] salarioRecebido = new float[3];

    public Gerente(String loja, double salarioBase, float[] salarioRecebido){
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarse(){
        System.out.println("Nome do gerente: " + getNome());
        System.out.println("Idade do gerente: " + getIdade());
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia(){
        double soma = 0;
        for(int i = 0; i < 3; i++){
            soma += salarioRecebido[i];
        }
        double media = soma / 3;
        return media;
    }

    public double calcularBonus(){
        return salarioBase * 0.35;
    }

    public String getloja(){
        return loja;
    }
    public void setloja(String loja){
        this.loja = loja;
    }
    public double getsalarioBase(){
        return salarioBase;
    }
    public void setsalarioBase(double salarioBase){
        this.salarioBase = salarioBase;
    }
    public float[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(float[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }
}
