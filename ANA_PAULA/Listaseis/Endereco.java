package Listaseis;

public class Endereco {
    String estado;
    String cidade;
    String bairro;
    int numero;
    String complemento;

    public void apresentarLogradouro(){
        String enderecoCompleto = numero + " " + complemento + ", " + bairro + ", " + cidade + ", " + estado;
        System.out.println("Endereço: " + enderecoCompleto);
    }
}
