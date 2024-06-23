package primeirobi.lista06;

public class Cliente extends Pessoa {

    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    public void apresentarse() {
        System.out.print("Me chamo " + getNome());
        System.out.print(" e tenho " + getIdade() + " anos. ");
        endereco.apresentarLogradouro();
    }
}
