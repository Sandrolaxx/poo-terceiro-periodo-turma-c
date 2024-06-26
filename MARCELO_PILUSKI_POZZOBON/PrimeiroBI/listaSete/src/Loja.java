package listaSete.src;

public class Loja {
    public int id;
    public String nome;
    public String razaoSocial;
    public String cnpj;
    public int[] vendedores = new int[99];
    public int[] clientes = new int[99];
    public Endereco endereco = new Endereco();

    public void apresentarse() {
        System.out.println("Loja: " + nome + "\nCNPJ: " + cnpj + "\nEndereço: " + endereco.cidade + ", " + endereco.bairro + ", " + endereco.rua);
    }

    public void addClientes(int idCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == 0) {
                clientes[i] = idCliente;
                break;
            }
        }
    }

    public int contarClientes() {
        int count = 0;
        for (int id : clientes) {
            if (id != 0) {
                count++;
            }
        }
        return count;
    }

    public void addVendedores(int idVendedores) {
        for (int i = 0; i < vendedores.length; i++) {
            if (vendedores[i] == 0) {
                vendedores[i] = idVendedores;
                break;
            }
        }
    }

    public int contarVendedores() {
        int count = 0;
        for (int id : vendedores) {
            if (id != 0) {
                count++;
            }
        }
        return count;
    }
}
