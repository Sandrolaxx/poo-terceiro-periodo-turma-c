package Listasete;

public class Vendedor extends Pessoa {
    private String loja = "Loja da Dona Gabrielinha1";
    private double salarioBase;
    private float[] salarioRecebido = new float[3];

    public void apresentarse(){
        String dados = "Nome do vendedor: "
            .concat(getNome())
            .concat(". Loja: ")
            .concat(getLoja())
            .concat(". Idade do vendedor: ")
            .concat(Integer.toString(getIdade()));
        System.out.println(dados);
    }

    public float calcularMedia(){
        float soma = 0;
        for(int i = 0; i < salarioRecebido.length; i++){
            soma += salarioRecebido[i];
        }
        float media = soma / salarioRecebido.length;
        return media;
    }

    public double calcularBonus(){
        double bonus = salarioBase * 0.2;
        return bonus;
    }



    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(float[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }
}
