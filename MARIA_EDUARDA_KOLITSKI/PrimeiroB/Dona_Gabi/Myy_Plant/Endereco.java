package PrimeiroB.Dona_Gabi.Myy_Plant;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, Integer numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println(numero + ", " + rua + ", " + complemento + " - " + bairro + ", " + cidade + ", " + estado);
    }
}