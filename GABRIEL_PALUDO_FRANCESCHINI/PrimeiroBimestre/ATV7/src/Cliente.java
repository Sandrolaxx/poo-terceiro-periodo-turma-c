package ATV7.src;

public class Cliente extends Pessoa {

    public Cliente(String nome, int idade, String estado, String cidade, String bairro, String rua, String numeroLugar, String complemento) {
        super(nome, idade, estado, cidade, bairro, rua, numeroLugar, complemento);
    }

    public void apresentarCliente() {
        System.out.println("Nome: "
        .concat(this.getNome() + " - Idade: " + this.getIdade()));
    }
}