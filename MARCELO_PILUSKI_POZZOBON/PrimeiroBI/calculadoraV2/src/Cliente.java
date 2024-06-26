package calculadoraV2.src;

public class Cliente {
    public int id;
    public String nome;
    public int idade;
    public String cidade;
    public String bairro;

    public void apresentarse() {
        System.out.println("Olá, eu sou o vendedor(a)" + nome + " e tenho " + idade + " anos de idade.");
    }
}
