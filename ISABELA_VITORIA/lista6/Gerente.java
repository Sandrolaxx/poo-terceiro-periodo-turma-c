package lista6;

public class Gerente extends Gerente2 {
   

    Loja loja = new Loja();
    Float salarioBase;
    Float[] salarioRecebido = new Float[3];

    public void apresentacao() {
        String mensagem = " Oii, sou " + nome + " e tenho " + idade + "de idade e trabalho na loja" + loja;
        System.out.println(mensagem);
    }

    public void calcularMedia() {
        Float salario = 0.2f;
        for (int i = 0; i < salarioRecebido.length; i++) {
            salario += salarioRecebido[i];
        }

        Float media = salario / salarioRecebido.length;
        System.out.println("A media salarial é: R$ " + media);
    }

    public void calculaBonus() {
        Float bonus = salarioBase * 0.35f;
        System.out.println("O bônus é de  R$" + bonus);
    }
}
