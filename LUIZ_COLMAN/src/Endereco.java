class Endereco {
    String estado;
    String cidade;
    String bairro;
    String numero;
    String complemento;

    // Método para apresentar o logradouro
    void apresentarLogradouro() {
        System.out.println(numero + ", " + complemento + " - " + bairro + ", " + cidade + ", " + estado);
    }
}
