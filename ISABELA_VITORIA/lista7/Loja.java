package lista7;

public class Loja {
    public String nome;
    public Endereco endereco;
    public String razaoSocial;
    private String cnpj;
    private Vendedor[] vendedores = new Vendedor[3];
    private Cliente[] clientes = new Cliente[3];
    private Item[] itens = new Item[100];
    private Integer posicaoItem = 0;

    public Loja(String nome, String razaoSocial, Endereco endereco, Vendedor[] vendedores, Cliente[] clientes) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public void contarVendedores() {
        int contador = 0;
        for (int i = 0; i < vendedores.length; i++) {
            if (vendedores[i] != null) {
                contador++;
            }
        }
        System.out.println("Número de vendedores " + nome + ": " + contador);
    }

    public void contarClientes() {
        int contador = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                contador++;
            }
        }
        System.out.println("Número de clientes: " + nome + ": " + contador);
    }
    public void apresentarse() {
        System.out.println("Nome da loja: " + nome + ", Razão social: " + razaoSocial + ", nosso CNPJ: " + cnpj + ", cidade: " + endereco.getCidade() + ", Bairro: " + endereco.getBairro() + ", Rua: " + endereco.getRua());
    }

    public void cadastrarItem(Item item) {
        item.setId(posicaoItem);
        itens[posicaoItem++] = item;
    }
    public void listarItens() {
        System.out.println("Lista de Itens: ");
        for (int i = 0; i < posicaoItem; i++) {
            itens[i].gerarDescricao();
        }
    }

    public Item listarItens(int id) {return itens[id];}
    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
    public Vendedor[] getVendedores() {return vendedores;}
    public Cliente[] getClientes() {return clientes;}
    public Item[] getItens() {return itens;}
    public Integer size() {return posicaoItem;}
}
