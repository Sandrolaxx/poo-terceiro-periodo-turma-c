package RICARDO_DINIZ_SILVA.Exemplos;

public class Main {
    
    public static void main(String[] args) {
        Professor primeiroProf = new Professor();


        primeiroProf.nome = "Sandro";
        primeiroProf.materia = "Projeto Orientado a Objetos";

        Professor segundoProf = new Professor();

        segundoProf.nome = "Maior";
        segundoProf.materia = "Estrutura de Dados";


        primeiroProf.professor();
        segundoProf.professor();


    }
}
