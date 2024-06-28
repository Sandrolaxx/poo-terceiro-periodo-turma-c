package aula_05;

public class FolhaPagamentoService {
  public void processa(Estagiario estagiario, Clt clt, Pj pj) {
    if (estagiario != null) {
      Double salario = estagiario.getSalario() + (estagiario.getSalario() * 0.01);

      System.out.println("Estagiario" + salario);
    } else if (clt != null) {
      Double salario = clt.getSalario() + (clt.getSalario() * 0.01);

      System.out.println("Estagiario" + salario);
    } else if (pj != null) {
      Double salario = pj.getSalario() + (pj.getSalario() * 0.01);

      System.out.println("Estagiario" + salario);
    }
  }
}
