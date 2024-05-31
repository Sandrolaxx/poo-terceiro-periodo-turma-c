package PrimeiroB.Dona_Gabi.Myy_Plant;

public class Cliente extends Pessoa {
    public Cliente(String nome, Integer idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    public void apresentarSe() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
    }
}