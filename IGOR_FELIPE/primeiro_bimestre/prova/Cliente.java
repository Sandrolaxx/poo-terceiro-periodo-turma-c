package primeiro_bimestre.prova;
import java.util.ArrayList;

public class Cliente {
    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private String telefone;

    public Cliente(String nome, Integer idade, String cpf, String telefone, ArrayList<Cliente> clientes){
        this.id = clientes.size() + 1;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Integer getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void listarClientes(){
        System.out.println("ID: "+id);
        System.out.println("Nome: "+nome);
        System.out.println("Idade: "+idade);
        System.out.println("CPF: "+cpf);
        System.out.println("Telefone: "+telefone);
        
    }
    
}
