package exemplos.aula6;

public class Professor {
    String nome;

    String materia;

    public void apresentarse() {
        String msg = "Olá ! sou o professor(a)"
        .concat (nome)
        .concat(" e eu vou te ensinar ")
        .concat (materia);
      
        System.out.println(msg);
      }
}
