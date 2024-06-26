package Listaseis;

public class Gerente extends Pessoa {
    String loja;
    double salarioBase;
    float[] salarioRecebido = new float[3];

    public void apresentarse(){
        System.out.println("Nome do gerente: " + nome);
        System.out.println("Idade do gerente: " + idade);
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
}
