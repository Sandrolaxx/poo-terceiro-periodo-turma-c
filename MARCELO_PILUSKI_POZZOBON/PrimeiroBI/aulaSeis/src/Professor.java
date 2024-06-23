package aulaSeis.src;

public class Professor {
    public String nome;
    public String materia;
    public Arma arma;

    public void apresentarse() {
        String msg = "Olá, sou o professor Marcelo!"
                .concat(nome)
                .concat(" e vou lecionar ")
                .concat(materia);
        System.out.println(msg);
    }
}