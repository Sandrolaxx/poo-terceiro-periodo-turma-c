package primeirob.atividadeObjeto;

// 2. Criar classe Cliente:
// com os atributos nome, idade, cidade, bairro e rua.
// Método apresentarse deve printar o nome, idade.

public class Cliente extends Pessoa {
    

    public Cliente(String nome, int idade, String estado, String cidade, String bairro, String rua) {
        super(nome, idade, estado, cidade, bairro, rua);
    }

    public void apresentarse() {
        String apresentar = "Cliente: " + getNome() + "\nIdade: " + getIdade();
        System.out.println(apresentar);
    }
}
