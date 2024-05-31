package primeirob.atividadeObjeto;

// 2. Crie uma classe Endereco com:
// - Com os atributos estado, cidade, bairro, numero e complemento.
// - Método apresentarLogradouro, printa de uma maneira interessante os dados de endereço concatenados.
// - Refatorar locais que utilizavam endereço.
public class Pessoa {
    private String nome;
    private int idade;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }



    public void apresentarse() {
        System.out.println("Pessoa [nome=" + getNome() + ", idade=" + getIdade() + ", estado=" + getEstado() + ", cidade=" + getCidade() + ", bairro="
                + getBairro() + ", rua=" + getRua() + "]");
    }

    public Pessoa(String nome, int idade, String estado, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }



}
