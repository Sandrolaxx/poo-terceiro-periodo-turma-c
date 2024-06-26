package primeiro_bimestre.aulaseis;

public class AulaSeisTest {
    public static void main(String[] args){
        Professor profeUm = new Professor();
        Professor oMelhorProfe = new Professor();

        profeUm.nome = "IgorBola";
        profeUm.materia = "A.I";

        oMelhorProfe.nome = "Sandrolaxx";
        oMelhorProfe.materia = "POO";

        profeUm.apresentarse();
        oMelhorProfe.apresentarse();

        Arma awp = new Arma();
        awp.nome = "AWP - Fiver Dream";
        awp.tipo = "AWP";
        awp.dano = 110;

        profeUm.arma = awp;
    }
}
