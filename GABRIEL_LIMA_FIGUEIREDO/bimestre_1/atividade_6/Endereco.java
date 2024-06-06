package bimestre_1.atividade_6;

public class Endereco {
  private String state;
  private String city;
  private String neighborhood;
  private String number;
  private String complement;
  
 public Endereco(String state, String city, String neighborhood, String number, String complement) {

  this.state = state;
  this.city = city;
  this.neighborhood = neighborhood;
  this.number = number;
  this.complement = complement;

 }

 public void apresentarLogradouro() {

  System.out.println(number + ", " + complement + ", " + neighborhood + ", " + city + ", " + state);

 }

 public String getState() {
  return state;
 }
 public void setState(String state) {

  this.state = state;
  
 }

}
