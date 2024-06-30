package primeirob.Lista05.test;

import primeirob.Lista05.domain.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void testarApresentarse() {
        Cliente cliente = Cliente.ClienteBuilder.builder()
                .nomePessoa("Joao")
                .idade(35)
                .cidade("Sta Lucia")
                .bairro("Centro")
                .rua("Av OLZ")
                .build();

        String resultadoEsperado = "Meu nome é: Joao, minha idade é: 35.";
        String resultadoAtual = cliente.apresentarse();

        assertEquals(resultadoEsperado, resultadoAtual);

    }
}
