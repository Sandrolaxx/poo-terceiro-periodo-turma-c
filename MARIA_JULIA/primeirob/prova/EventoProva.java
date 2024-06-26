package MARIA_JULIA.prova;

import java.util.ArrayList;

// 3. Crie uma classe Loja com:
// Atributos, nome fantasia, razão social, cpnj, cidade, bairro, rua, array vendedores, array de clientes.
// contarClientes, mosta a quantidade de clientes
// contarVendedores, mosta a quantidade de vendedores.
// Método apresentarse, printa nomeFantasia, cnpj e endereco.

public class EventoProva{
    private int id; 
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String nome;
    private double valorIngresso;
    

    private ArrayList<ClienteProva> clientes = new ArrayList<>();
    private ArrayList<IngressoProva> ingressosVendidos = new ArrayList<>();
    


    @Override
    public String toString() {
        return "EventoProva [id=" + id + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado="
                + estado + ", nome=" + nome + ", clientes=" + clientes + ", ingressosVendidos=" + ingressosVendidos
                + ", IngressoTipo=" + IngressoTipo + "]";
    }

    private IngressoProva IngressoTipo;

    public EventoProva(int id,String rua, String bairro, String cidade, String estado, String nome, double valorIngresso) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
        this.valorIngresso = valorIngresso;

    }

    public String getRua() {
        return rua;
    }


    public void setRua(String rua) {
        this.rua = rua;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public ArrayList<ClienteProva> getClientes() {
        return clientes;
    }




    public void setClientes(ClienteProva cliente) {
        clientes.add(cliente);
    }
    public ArrayList<IngressoProva> getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(ArrayList<IngressoProva> ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }

    public IngressoProva getIngressoTipo() {
        return IngressoTipo;
    }

    public void setIngressoTipo(IngressoProva ingressoTipo) {
        IngressoTipo = ingressoTipo;
    }



    

    

}
