package primeirobi.lista05;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.print("Me chamo " + nome);
        System.out.print(" e tenho " + idade + " anos. Moro na rua ");
        endereco.apresentarEndereco();
    }
}
