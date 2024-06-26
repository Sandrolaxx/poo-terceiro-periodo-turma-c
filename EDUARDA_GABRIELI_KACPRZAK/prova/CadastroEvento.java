package EDUARDA_GABRIELI_KACPRZAK.prova;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroEvento {
    private static List<Evento> eventos = new ArrayList<>();
    private static Scanner entrada = new Scanner(System.in);

    public class Evento {
        private String nomeEvento;
        private LocalDate data;
        private String local;
        private String descricao;
    
        public Evento(String nomeEvento, LocalDate data, String local, String descricao) {
            this.nomeEvento = nomeEvento;
            this.data = data;
            this.local = local;
            this.descricao = descricao;
        }
    
        public String getNomeEvento() {
            return nomeEvento;
        }

        public int getIngressosDisponiveis() {
            throw new UnsupportedOperationException("Unimplemented method 'getIngressosDisponiveis'");
        }
    }

    @SuppressWarnings("unused")
    private static void cadastrarEvento() {
    System.out.println("\\nCadastro de Evento");
    System.out.println("-----------------");

    System.out.print("Nome do Evento: ");
    String nome = entrada.nextLine();

    System.out.print("Data do Evento (dd/mm/aaaa): ");
    String dataString = entrada.nextLine();
    LocalDate data = LocalDate.parse(dataString);

    System.out.print("Local do Evento: ");
    String local = entrada.nextLine();

    System.out.print("Descrição do Evento: ");
    String descricao = entrada.nextLine();

    Evento evento = new Evento(nome, data, local, descricao);
    eventos.add(evento);

    System.out.println("\nEvento cadastrado com sucesso!");
        }
    }

