package segunda_versao.model;

public class Cliente extends Pessoa {

    public Cliente(String nome, int idade, Endereco endereco) {
        super.nome = nome;
        super.idade = idade;
        super.endereco = endereco;
    }

    @Override
    public void apresentarSe() {
        System.out.println("Nome do cliente: " + getNome());
        System.out.println("Idade do cliente: " + getIdade());
    }
    
    @Override
    public String getNome(){
        return this.nome;
    }
}
