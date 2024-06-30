package primeirobimestre.list7.generated_class;

import primeirobimestre.list7.domain.domains.Endereco;
import primeirobimestre.list7.domain.domains.*;
import primeirobimestre.list7.enums.endereco.Estado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class GeneretedClass {
    private static Long idItemCompra = 1L;
    private static final List<String> NAMES = new ArrayList<>(
            List.of("Maria", "Joana", "Angela", "Cleusa", "Silvana", "Salete", "Rosana", "jaqueline", "Josiane")
    );
    private static final List<String> BAIRROS = new ArrayList<>(
            List.of(
                    "Centro", "Alto da XV", "Batel", "Capão Raso", "Cidade Industrial de Curitiba",
                    "Humberto I", "Santa Felicidade", "Sítio Cercado", "Tingui", "Uberaba"
            )
    );
    private static final List<String> RUAS = new ArrayList<>(
            List.of(
                    "Rua Major Marcelino", "Rua Antônio Bento", "Rua XV de Novembro", "Rua Rui Barbosa",
                    "Rua Marechal Deodoro", "Rua Barão do Rio Branco", "Rua Afonso Pena", "Rua Sete de Setembro",
                    "Rua Carlos Gomes", "Rua XV de Novembro"
            )
    );
    private static final List<String> COMPLEMENTOS = new ArrayList<>(
            List.of(
                    "Apartamento", "Casa", "Kitnet", "Sobrado", "Chalé", "Prédio", "Loteamento", "Condomínio",
                    "Vila", "Fazenda"
            )
    );
    private static final List<String> NOMES_PRODUTOS = new ArrayList<>(
            List.of(
                    "Rosa", "Cravo", "Girassol", "Lírio", "Orquídea", "Lavanda", "Margarida", "Tulipano", "Jasmim", "Gerbera"
            )
    );
    private static final RandomGenerator RANDOM = new Random();

    public static Endereco gerarEndereco() {
        return Endereco.EnderecoBuilderLista07.builder()
                .estado(Estado.PR)
                .cidade("Cascavel")
                .bairro(gerarBairro())
                .rua(gerarRua())
                .complemento(gerarComplemento())
                .numero(gerarNumeroEndereco())
                .build();
    }
    public static Cliente cliente() {
        return Cliente.ClienteBuilderLista07.builder()
                .nome(gerarNome())
                .idade(gerarIdade())
                .endereco(gerarEndereco())
                .build();
    }

    public static Vendedor vendedor() {
        return Vendedor.VendedorBuilderLista07.builder()
                .nome(gerarNome())
                .idade(gerarIdade())
                .salarioBase(gerarSalario())
                .salarioRecebido(List.of(gerarSalario(), gerarSalario(), gerarSalario()))
                .endereco(gerarEndereco())
                .build();
    }

    public static Gerente gerente() {
        return Gerente.GerenteBuilderLista07.builder()
                .nome(gerarNome())
                .idade(gerarIdade())
                .salarioBase(gerarSalario())
                .salarioRecebido(List.of(gerarSalario(), gerarSalario(), gerarSalario()))
                .endereco(gerarEndereco())
                .build();
    }

    public static Loja loja() {
        return Loja.LojaBuilderLista07.builder()
                .nomeFantasia("Beija Flor")
                .razaoSocial("Beija Flor LTDA")
                .cnpj(88765449000191L)
                .endereco(gerarEndereco())
                .build();
    }

    public static ItemCompra itemCompra() {
        return ItemCompra.ItemCompraBuilderLista07.builder()
                .id(idItemCompra++)
                .nome(gerarNomeProduto())
                .tipo("Flor")
                .valor(gerarPrecoProduto())
                .build();
    }

    private static String gerarNome() {
        return NAMES.get(RANDOM.nextInt(0,8));
    }

    private static int gerarIdade() {
        return RANDOM.nextInt(20, 70);
    }

    private static int gerarNumeroEndereco() {
        return RANDOM.nextInt(100, 999);
    }

    private static String gerarBairro() {
        return BAIRROS.get(RANDOM.nextInt(0, 9));
    }

    private static String gerarRua() {
        return RUAS.get(RANDOM.nextInt(0,9));
    }

    private static String gerarComplemento() {
        return COMPLEMENTOS.get(RANDOM.nextInt(0, 9));
    }

    private static String gerarNomeProduto() {
        return NOMES_PRODUTOS.get(RANDOM.nextInt(0, 9));
    }

    private static double gerarSalario() {
         return RANDOM.nextDouble(1420, 20000);
    }

    private static double gerarPrecoProduto() {
         return RANDOM.nextDouble(0.99, 100);
    }
}
