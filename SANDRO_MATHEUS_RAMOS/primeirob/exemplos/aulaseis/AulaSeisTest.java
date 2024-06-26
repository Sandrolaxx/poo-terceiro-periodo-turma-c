package primeirob.exemplos.aulaseis;

public class AulaSeisTest {
    
    public static void main(String[] args) {
        
        Professor profeUm = new Professor();
        Professor oMelhorProfe = new Professor();

        profeUm.nome = "IgorBola";
        profeUm.materia = "A.I";

        oMelhorProfe.nome = "Sandrolaxx";
        oMelhorProfe.materia = "POO";

        profeUm.apresentarse();
        oMelhorProfe.apresentarse();

    }

}
