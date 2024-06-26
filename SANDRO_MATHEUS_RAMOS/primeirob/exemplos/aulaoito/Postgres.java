package primeirob.exemplos.aulaoito;

public class Postgres implements IBancoDados {
    
    public void salvar() {
        System.out.println("Salvando dados PG..");
    }
    
    public void buscar() {
        System.out.println("Buscar dados PG...");
    }
    
    public void alterar() {
        System.out.println("Alterar dados PG...");
    }
    
    public void deletar() {
        System.out.println("Deletar dados PG...");
    }

}
