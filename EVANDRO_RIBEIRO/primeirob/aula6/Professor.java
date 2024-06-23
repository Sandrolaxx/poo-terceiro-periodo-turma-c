package aula6;

public class Professor {
    
    String nome;

    String materia;

    public void aprenstarse() {
        String msg = "Olá! Sou o professor"
                .concat(nome)
                .concat("e vou lecionar")
                .concat(materia);

        System.out.println(msg);
        
    }

}
