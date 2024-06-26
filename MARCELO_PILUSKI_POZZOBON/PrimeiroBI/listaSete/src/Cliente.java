package listaSete.src;

public class Cliente extends Pessoa{
    public int idCliente;

    public void apresentarse() {
        System.out.println("Olá, eu sou o vendedor(a)" + nome + " e tenho " + idade + " anos de idade.");
    }
}
