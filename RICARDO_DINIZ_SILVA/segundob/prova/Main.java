package RICARDO_DINIZ_SILVA.segundob.prova;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibir();
    }
}

class Menu {
    private ServicoAluno servicoAluno = new ServicoAluno();
    private ServicoTestemunho servicoTestemunho = new ServicoTestemunho();

    public void exibir() {
        while (true) {
            String[] opcoes = {"Listagem dos alunos", "Criar registro de testemunho", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    listarAlunos();
                    break;
                case 1:
                    criarTestemunho();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    private void listarAlunos() {
        try {
            String alunos = servicoAluno.obterAlunos();
            JOptionPane.showMessageDialog(null, alunos, "Listagem dos alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            Modal.mostrarErro("Erro ao listar alunos: " + e.getMessage());
        }
    }

    private void criarTestemunho() {
        JTextField campoUrlFoto = new JTextField();
        JTextField campoRa = new JTextField();
        JTextField campoTexto = new JTextField();
        Object[] mensagem = {
            "URL da foto:", campoUrlFoto,
            "RA do aluno:", campoRa,
            "Texto do testemunho:", campoTexto
        };

        int opcao = JOptionPane.showConfirmDialog(null, mensagem, "Criar registro de testemunho", JOptionPane.OK_CANCEL_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            String urlFoto = campoUrlFoto.getText();
            String ra = campoRa.getText();
            String texto = campoTexto.getText();

            try {
                servicoTestemunho.criarTestemunho(urlFoto, ra, texto);
                Modal.mostrarSucesso("Testemunho criado com sucesso!");
            } catch (Exception e) {
                Modal.mostrarErro("Erro ao criar testemunho: " + e.getMessage());
            }
        }
    }
}

class ServicoAluno {
    private static final String URL_BASE = "https://poo-exam.vercel.app/api/students";
    private HttpClient cliente = HttpClient.newHttpClient();

    public String obterAlunos() throws Exception {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE))
                .build();

        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

        if (resposta.statusCode() == 200) {
            return resposta.body();
        } else {
            throw new Exception("Falha ao buscar alunos: " + resposta.body());
        }
    }
}

class ServicoTestemunho {
    private static final String URL_BASE = "https://poo-exam.vercel.app/api/testimonial";
    private HttpClient cliente = HttpClient.newHttpClient();

    public void criarTestemunho(String urlFoto, String ra, String texto) throws Exception {
        String json = String.format("{\"photoUrl\":\"%s\", \"ra\":\"%s\", \"text\":\"%s\"}", urlFoto, ra, texto);

        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

        if (resposta.statusCode() != 201) {
            throw new Exception("Falha ao criar testemunho: " + resposta.body());
        }
    }
}

class Modal {
    public static void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
