public class Endereco {
    private String cidade;

    private String bairro;

    private String estado;

    private String complemento;

    private int numero;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String apresentarLogradouro() {
        String retornoLogradouro =
                "\nNumero do local: " + getNumero() + "\nBairro: " + getBairro() +
                        "\nCidade: " + getCidade() + "\nEstado: " + getEstado() +
                        "\nComplemento do local: " + getComplemento();
        return retornoLogradouro;
    }
}
