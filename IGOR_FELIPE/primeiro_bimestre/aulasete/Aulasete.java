package primeiro_bimestre.aulasete;

public class Aulasete {
    public static void main(String[] args) {
        Pato patoBala = new Pato();
        BemTiVi passaro = new BemTiVi();

        patoBala.nome = "Pato Show";
        patoBala.tipo = "Pato";

        patoBala.voar();
        passaro.voar();
    }
}
