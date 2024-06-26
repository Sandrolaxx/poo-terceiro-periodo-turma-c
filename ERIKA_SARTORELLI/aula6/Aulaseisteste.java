package exemplos.aula6;

public class Aulaseisteste {
    public static void main(String[] args){
        Professor profeUm =new Professor();
        Professor melhorProf = new Professor();

        profeUm.nome =" igorBola ";
        profeUm.materia=" A.I ";

        melhorProf.nome =" sandro ";
        melhorProf.materia= " Poo ";

        profeUm.apresentarse();
        melhorProf.apresentarse();
    }
}
