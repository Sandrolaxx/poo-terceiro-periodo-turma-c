package segundo_bimestre.listas.lista2;
import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // ATIVIDADE 1 ===============================
        System.out.println("\n========== ATIVIDADE 1 ==========\n");

        List<Integer> numeros = Arrays.asList(1,4,3,5,10,12,13,7);
        List<Integer> numerosPares = new ArrayList<>();

        numerosPares = numeros.stream()
            .filter(numero -> numero % 2 == 0)
            .toList();

        numerosPares.forEach(n -> System.out.println(n));

        // ATIVIDADE 2 ===============================
        System.out.println("\n========== ATIVIDADE 2 ==========\n");

        List<String> nomes = Arrays.asList("roberto","josé","caio","vinicius");

        List<String> nomesArrumados = new ArrayList<>();

        nomesArrumados = nomes.stream()
            .map(String::toUpperCase)
            .toList();

        nomesArrumados.forEach(nome -> System.out.println(nome));

        // ATIVIDADE 3 ===============================
        System.out.println("\n========== ATIVIDADE 3 ==========\n");

        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");


        Map<String, Long> palavrasa = palavras.stream()
            .collect(Collectors.groupingBy(palavra -> palavra,Collectors.counting()));
        
        palavrasa.forEach((palavra, contagem) -> System.out.println("Palavra: "+palavra+"|| QTD: "+contagem));
    
        // ATIVIDADE 4 ===============================
        System.out.println("\n========== ATIVIDADE 4 ==========\n");
    
        List<Produto> listaProdutos = Arrays.asList(
            new Produto("produto1",50.0),
            new Produto("produto2",110.0),
            new Produto("produto3",130.0),
            new Produto("produto4",90.0));
    
        List<Produto> produtosCem = listaProdutos.stream()
            .filter(produto -> produto.getValor()>100)
            .toList();
    
        produtosCem.forEach(produto -> System.out.println("Produto: " +produto.getNome()+" Valor: "+produto.getValor()));
    
        // ATIVIDADE 5 ===============================
        System.out.println("\n========== ATIVIDADE 5 ==========\n");
    
        Double somaProdutos = listaProdutos.stream()
            .map(num -> num.getValor())
            .reduce(0d,(valorAnterior,valorAtual) -> valorAnterior + valorAtual);

            
        System.out.println("Soma do preço dos produtos: "+somaProdutos);

        // ATIVIDADE  ===============================
       System.out.println("\n========== ATIVIDADE 6 ==========\n");

        List<String> linguagens = Arrays.asList("Java","Python","C","JavaScript","Ruby");

        List<String> linguagensOrdenado = linguagens.stream()
            .sorted((lingua1, lingua2) -> Integer.compare(lingua1.length(), lingua2.length()))
            .collect(Collectors.toList());

        linguagensOrdenado.forEach(linguas -> System.out.println(linguas));
    }
    


        
        
} 