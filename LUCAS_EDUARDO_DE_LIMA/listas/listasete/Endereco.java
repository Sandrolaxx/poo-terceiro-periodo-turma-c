package LUCAS_EDUARDO_DE_LIMA.listas.listasete;


/*Crie uma classe Endereco com:
- Com os atributos estado, cidade, bairro, numero e complemento.
- Método apresentarLogradouro, printa de uma maneira interessante os dados de endereço concatenados.
- Refatorar locais que utilizavam endereço.*/

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
    
