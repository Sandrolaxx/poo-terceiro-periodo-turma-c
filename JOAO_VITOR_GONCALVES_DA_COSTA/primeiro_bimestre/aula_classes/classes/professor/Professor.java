package classes.professor;

public class Professor {

  String nome;
  String materia;

  public void apresentarse() {
    String msg = "Olá! Sou o professor(a) "
        .concat(this.nome)
        .concat(" e vou lecionar ")
        .concat(this.materia);

    System.out.println(msg);
  }
}
