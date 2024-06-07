package exemplos.aulaseis;

public class Professor {

    String arma;

    String nome;
    
    String materia;

    public void apresentarse (){
        String msg = "Olá! sou o Professor(a) "
            .concat(nome)
            .concat(" e vou lecionar ")
            .concat(materia);

        System.out.println(msg);
        
    }
}
