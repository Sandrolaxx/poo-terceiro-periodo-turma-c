package lista_5;

public class Cliente extends Pessoa {
    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        super(nome, idade, cidade, bairro, rua);
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
