public class Cliente extends Pessoa {
    @Override
    public void apresentarse() {
        System.out.println("Nome do cliente: " + getNome());
        System.out.println("Idade do cliente: " + getIdade());
    }
}
