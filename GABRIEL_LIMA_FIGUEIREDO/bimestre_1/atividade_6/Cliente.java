package bimestre_1.atividade_6;


public class Cliente {

private String name;
private int age;
private Endereco endereco;



public Cliente(String name, int age, String state, String city, String neighborhood, String number, String complement ) {

this.name = name;
this.age = age;
this.endereco = new Endereco(state, city, neighborhood, number, complement);

}

public void apresenteSe() {

System.out.println("Nome: " + name);
System.out.println("Idade: " + age);


}




  
}
  
