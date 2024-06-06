package bimestre_1.atividade_5;

public class Cliente {

private String name;
private int age;
private String city;
private String neighborhood;
private String street;


public Cliente(String name, int age, String city, String neighborhood, String street) {

this.name = name;
this.age = age;
this.city = city;
this.neighborhood = neighborhood;
this.street = street;

}

public void apresenteSe() {

System.out.println("Nome: " + name);
System.out.println("Idade: " + age);


}




  
}
