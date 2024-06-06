package bimestre_1.atividade_6;

public class Gerente {

 private String name;
 private int age;
 private String store;
 public Endereco endereco;
 private float wageB;
 private float[] wageR;

  
 public Gerente(String name, int age, String store, float wageB, float[] wageR, String state, String city, String neighborhood, String number, String complement ) {
  this.name = name;
  this.age = age;
  this.store = store;
  this.wageB = wageB;
  this.wageR = wageR;
  this.endereco = new Endereco(state, city, neighborhood, number, complement);

  }
  public void apresentarse() {
    System.out.println("-----------------------------------------");
    System.out.println("      INFORMAÇÕES DO GERENTE                ");
    System.out.println(" ");
   System.out.println("Nome Gerente: " + name);
   System.out.println("Idade Gerente: " + age);
   System.out.println("Loja em que atua: " + store);
   System.out.println("-----------------------------------------");
  }

  public float calcularMedia() {

  float soma = 0;

  for (float salario : wageR) {
    soma += salario;
  }
 return soma / wageR.length;
  }

  public float calcularBonus() {
  
    return wageB * 0.35f;

  }
  public String getNome() {
    return name;
  }

  public void setNome(String name) {
    this.name = name;
  }

}
  


