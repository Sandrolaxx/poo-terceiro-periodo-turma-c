class Cliente extends Endereco{
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    // Método para apresentar informações do cliente
    void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}