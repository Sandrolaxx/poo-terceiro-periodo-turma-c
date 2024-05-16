package primeirobimetre.lista_1.lista_6;

public class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
