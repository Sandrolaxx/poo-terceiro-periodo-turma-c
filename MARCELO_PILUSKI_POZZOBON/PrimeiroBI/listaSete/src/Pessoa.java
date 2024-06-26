package listaSete.src;

public class Pessoa {
    public int id;
    public String nome;
    public int idade;
    public Loja loja = new Loja();
    public String nomeLoja = loja.nome;
    public Endereco endereco = new Endereco();

}
