package primeiro_bimestre.aulaoito;

public class AulaOitoTeste {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("Sandro",25);

        System.out.println(vendedor.getNome());

        vendedor.setNome("Cleber");
        System.out.println(vendedor.getNome());
    }

    public static void salvar(Postgres pg){
        pg.salvar();
    }
}
