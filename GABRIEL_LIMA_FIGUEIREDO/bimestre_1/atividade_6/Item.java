package bimestre_1.atividade_6;

public class Item {
  private int numberSeries;
  private String name;
  private String type;
  private float value;
   
  public Item(int numberSeries, String name, String type, float value) {
    this.name = name;
    this.type = type;
    this.numberSeries = numberSeries;
    this.value = value;
  }
 
  public void gerarDescricao() {
    System.out.println("name: " + name);
    System.out.println("número de série: " + numberSeries);
    System.out.println("tipo: " + type);
    System.out.println("Valor do produto: " + value);
  }

 public int getnumberSeries() {
  return numberSeries;
 }

 public void setnumberSeries(int numberSeries) {
  this.numberSeries = numberSeries;
 }
 public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public String getTipo() {
  return type;
}

public void setType(String type) {
  this.type = type;
}

public float getValue() {
  return value;
}

public void setValue(float value) {
  this.value = value;
}


}

