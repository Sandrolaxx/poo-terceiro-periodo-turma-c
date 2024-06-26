package lista4;

public class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;
    
    public void apresentarse(){
        System.out.println("Oii, sou " + nome +" e tenho " + idade +"anos");
    }
}