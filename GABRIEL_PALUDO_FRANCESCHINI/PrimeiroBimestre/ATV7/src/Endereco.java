package ATV7.src;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numeroLugar;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, String numeroLugar, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroLugar = numeroLugar;
        this.complemento = complemento;
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

    public String getNumeroLugar() {
        return numeroLugar;
    }

    public String getComplemento() {
        return complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Rua " + this.getRua()
            .concat(", " + this.getNumeroLugar())
            .concat(", bairro " + this.getBairro())
            .concat(", " + this.getComplemento())
            .concat(", " + this.getCidade())
            .concat(" - " + this.getEstado())
        );
    }
}