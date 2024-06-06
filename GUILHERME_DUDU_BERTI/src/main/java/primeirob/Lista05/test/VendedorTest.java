package primeirob.Lista05.test;

import primeirob.Lista05.domain.Vendedor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VendedorTest {

    @Test
    public void testarApresentarse() {
        Vendedor vendedor = Vendedor.VendedorBuilder.builder()
                .nomePessoa("João")
                .idade(30)
                .loja(null)
                .cidade("Sta Lucia")
                .bairro("Centro")
                .rua("Av OLZ")
                .salarioBase(1800)
                .salarioRecebido(new double[]{1500, 1800, 1900})
                .build();
        String resultadoEsperado = "Meu nome é: João, minha idade é: 30, minha loja é: null.";
        String resultadoAtual = vendedor.apresentarse();

        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void testarSalarioBonus() {
        Vendedor vendedor = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Joao")
                .idade(30)
                .loja(null)
                .cidade("Sta Lucia")
                .bairro("Centro")
                .rua("Av OLZ")
                .salarioBase(1800)
                .salarioRecebido(new double[]{1500, 1800, 1900})
                .build();
        double resultadoEsperado = 360;
        double resultadoAtual = vendedor.calcularBonus();

        assertEquals(resultadoEsperado, resultadoAtual, 0.02);
    }

    @Test
    public void testarMediaSalarial() {
        Vendedor vendedor = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Joao")
                .idade(30)
                .loja(null)
                .cidade("Sta Lucia")
                .bairro("Centro")
                .rua("Av OLZ")
                .salarioBase(1800)
                .salarioRecebido(new double[]{1500, 1800, 1900})
                .build();

        double resultadoEsperado = 1733.33;
        double resultadoAtual = vendedor.calcularMedia();

        assertEquals(resultadoEsperado, resultadoAtual, 3);

    }

}
