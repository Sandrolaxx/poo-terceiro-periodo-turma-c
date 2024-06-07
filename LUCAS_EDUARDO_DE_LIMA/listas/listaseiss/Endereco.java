package listas.listaseiss;

public class Endereco {

    String estado;
    String cidade;
    String bairro;
    int numero;
    String complemento;

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println(
                "Estado: " + estado + ".\n" +
                "Cidade: " + cidade + ".\n" +
                "Bairro: " + bairro + ".\n" +
                "Numero: " + numero + ".\n" +
                "Complemento: " + complemento + "."
        );
    }
}