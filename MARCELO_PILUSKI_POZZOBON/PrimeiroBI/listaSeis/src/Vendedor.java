package listaSeis.src;

public class Vendedor extends Pessoa {
    public int idVendedor;
    public int salarioBase;
    public int[] salarioRecebido = new int[99];
    public int[] bonusMensal = new int[99];

    public void apresentarse() {
        System.out.println("Olá, eu sou o vendedor(a) " + nome + ", moro na cidade " + endereco.cidade + ", no bairro " + endereco.bairro
                + ", na rua " + endereco.rua + "!");
    }

    public void calcularMedia() {
        int total = 0;
        for (int i = 0; i < salarioRecebido.length - 1; i++) {
            total += salarioRecebido[i];
        }
        total = total / salarioRecebido.length;
        System.out.println("A média salarial foi de: " + total);
    }

    public void calcularBonus() {
        int totalBonus = 0;
        for (int i = 0; i <= salarioRecebido.length - 1; i++) {
            if (salarioRecebido[i] == 0) {
                break;
            } else {
                bonusMensal[i] = (salarioRecebido[i] * 2) / 100;
                totalBonus += bonusMensal[i];
                System.out.println("Seu bônus do salário " + i + " foi de: " + totalBonus);
            }

        }

    }
}
