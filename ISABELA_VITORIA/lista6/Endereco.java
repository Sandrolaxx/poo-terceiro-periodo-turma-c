package lista6;


public class Endereco {
    String estado;
    String cidade;
    String bairro;
    String rua;
    int numero;
    String complemento;

    public void apresentarLogradouro(){
        String mensagem = "Endereço" + rua +
        ", Numero: " + numero + "Complemento: "+ complemento + ", Bairro: " + bairro + " ,Cidade: " + cidade + " ,Estado: "+ estado;
        
        System.out.println(mensagem);
    }
}