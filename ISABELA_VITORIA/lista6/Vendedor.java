package lista6;

public class Vendedor {
    String nome;
    int idade;
    Loja loja;
    String cidade;
    String bairro;
    String rua;
    Float salarioBase;
    Float[] salarioRecebido = new Float[3];

    public void apresentarse() {
        System.out.println("Ola, sou " + nome + " tenho " + idade + " de idade, e sou propietaria da loja " + loja.nomeFantasia + ".");
    }

    public void calcularMedia() {
        Double total = 0.2;
        for (int i = 0; i < 3; i++) {
            total += salarioRecebido[i];
        }

        Double media = total / 3;
        System.out.println("A media salarial é: R$ " + media);
    }

    public void calculaBonus (){
        System.out.println("O bonus é: R$" + (salarioBase *0.2) );
    }
}

