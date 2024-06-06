package primeiro_bimestre.aulaseis;

public class Professor {
    
    String nome;

    String materia;

    Arma arma;

    public void apresentarse(){
        String msg = "Olá! Sou o professor(a) "
            .concat(nome)
            .concat(" e vou lecionar ")
            .concat(materia);

        System.out.println(msg);
    }
}
