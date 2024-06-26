package primeirob.exemplos.aulaoito;

public class AulaOitoTeste {
    
    public static void main(String[] args) {

        // Vendedor vendedor = new Vendedor("Sandro", 25);

        // System.out.println(vendedor.getNome());

        // vendedor.setNome("Cleber");
        // System.out.println(vendedor.getNome());

        Postgres pg = new Postgres();
        Oracle oracle = new Oracle();
        Mongo mongo = new Mongo();

        salvar(pg);
        salvar(oracle);
        salvar(mongo);

        System.out.println(Math.random() * 100);
    }
    
    public static void salvar(IBancoDados db) {
        db.salvar();
    } 

}
