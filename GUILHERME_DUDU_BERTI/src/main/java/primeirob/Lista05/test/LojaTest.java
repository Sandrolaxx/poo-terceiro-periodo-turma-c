package primeirob.Lista05.test;

import primeirob.Lista05.domain.Cliente;
import primeirob.Lista05.domain.Loja;
import primeirob.Lista05.domain.Vendedor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LojaTest {
        @Test
        public void testarConstrutor() {
                Loja loja = Loja.LojaBuilder.builder()
                                .cidade("Santa Lúcia")
                                .bairro("Centro")
                                .rua("Av. O. L. Z.")
                                .nomeFantasia("Vandir Rech")
                                .razaoSocial("Magazine Móveis")
                                .cnpj("17235604000110")
                                .vendedores(null)
                                .clientes(null)
                                .build();
                // Asserções para verificar os atributos da loja
                assertEquals("Santa Lúcia", loja.getCidade());
                assertEquals("Centro", loja.getBairro());
                assertEquals("Av. O. L. Z.", loja.getRua());
                assertEquals("Vandir Rech", loja.getNomeFantasia());
                assertEquals("Magazine Móveis", loja.getRazaoSocial());
                assertEquals("17235604000110", loja.getCnpj());
        }

        @Test
        public void testarContarVendedores() {
                Vendedor vendedor1 = Vendedor.VendedorBuilder.builder()
                                .nomePessoa("Joao")
                                .idade(30)
                                .loja(null)
                                .cidade("Sta Lucia")
                                .bairro("Centro")
                                .rua("Av OLZ")
                                .salarioBase(1800)
                                .salarioRecebido(new double[] { 1500, 1800, 1900 })
                                .build();

                Vendedor vendedor2 = Vendedor.VendedorBuilder.builder()
                                .nomePessoa("Maria")
                                .idade(45)
                                .loja(null)
                                .cidade("Sta Lucia")
                                .bairro("Centro")
                                .rua("Rua B")
                                .salarioBase(1900)
                                .salarioRecebido(new double[] { 1600, 1300, 1200 })
                                .build();
                Loja loja = Loja.LojaBuilder.builder()
                                .cidade("Salu")
                                .bairro("Centro")
                                .rua("AVLZ")
                                .nomeFantasia("Magazine ST")
                                .razaoSocial("Vandir")
                                .cnpj("17235604000110")
                                .vendedores(new Vendedor[] { vendedor1, vendedor2 })
                                .clientes(new Cliente[] {})
                                .build();

                int numeroVendedoresEsperado = 2;
                int numeroVendedoresAtual = loja.contarVendedores();

                assertEquals(numeroVendedoresEsperado, numeroVendedoresAtual);
        }

        @Test
        public void testarContarClientes() {
                Cliente cliente1 = Cliente.ClienteBuilder.builder()
                                .nomePessoa("Jorge")
                                .idade(45)
                                .cidade("Sta Lucia")
                                .bairro("Centro")
                                .rua("Av OLZ")
                                .build();
                Cliente cliente2 = Cliente.ClienteBuilder.builder()
                                .nomePessoa("Mario")
                                .idade(50)
                                .cidade("Sta Lucia")
                                .bairro("Centro")
                                .rua("Av Brasil")
                                .build();
                Loja loja = Loja.LojaBuilder.builder()
                                .cidade("Salu")
                                .bairro("Centro")
                                .rua("AVLZ")
                                .nomeFantasia("Magazine ST")
                                .razaoSocial("Vandir")
                                .cnpj("17235604000110")
                                .vendedores(new Vendedor[] {})
                                .clientes(new Cliente[] { cliente1, cliente2 })
                                .build();
                int numeroClientesEsperado = 2;
                int numeroClientesAtual = loja.contarClientes();

                assertEquals(numeroClientesEsperado, numeroClientesAtual);
        }
}
