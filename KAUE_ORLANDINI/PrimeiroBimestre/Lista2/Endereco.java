package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

public class Endereco {

    private String bairro;
    
    private String cidade;

    private String rua;
    
    private String estado;
    
    private Double numero;
    
    private String complemento;

    

    public Endereco(String bairro, String cidade, String rua, String estado, Double numero, String complemento) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }

    void apresentarLogradouro() {
        System.out.println("estado: " + String.valueOf(estado) + String.valueOf(", cidade: ") + String.valueOf(cidade) + String.valueOf(", bairro: ") + String.valueOf(bairro) + String.valueOf(", rua: ") + String.valueOf(rua) + String.valueOf(", numero: ") + String.valueOf(numero).concat(", complemento:").concat(complemento));
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getEstado() {
        return estado;
    }

    public Double getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    
    
}
