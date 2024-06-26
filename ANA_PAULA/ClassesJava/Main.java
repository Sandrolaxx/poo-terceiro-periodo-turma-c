package ClassesJava;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor();
        Cliente cliente = new Cliente();
        Loja loja = new Loja();
        
        vendedor.apresentarse();
        vendedor.calcularBonus(59);
        vendedor.salarioRecebido[0]= 894;
        vendedor.salarioRecebido[1]= 987;
        vendedor.salarioRecebido[2]= 456;
        System.out.println("Média dos salários dos vendedores:" + vendedor.calcularMedia(vendedor.salarioRecebido));
        
        
        cliente.apresentarse();

        loja.apresentarse();
        loja.clientes[0] = "Jorge";
        loja.clientes[1] = "Ana";
        loja.clientes[2] = "Sofia";
        loja.contarClientes(loja.clientes);
        loja.vendedores[0] = "Joao";
        loja.vendedores[1] = "Murilo";
        loja.vendedores[2] = "Gabriel";
        loja.contarVendedores(loja.vendedores);
    
    }



}
