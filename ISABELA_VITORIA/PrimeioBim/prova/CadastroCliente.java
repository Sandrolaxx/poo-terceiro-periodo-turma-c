package ISABELA_VITORIA.prova;

public class CadastroCliente {

    public CadastroCliente() {
        this.cliente = new Cliente();
    }

    public void cadastrarCliente(Cliente cliente) {
        eventos.add(cliente);
    }

    public void listarClientes() {
        return cliente;
    }
}
