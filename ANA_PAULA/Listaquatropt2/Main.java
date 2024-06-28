package Segundobim.Listaquatropt2;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        while (true) {
            List<String> opcao = List.of("Listagem de convênios", "Consulta de Boletos");
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcao.toArray(), opcao.toArray()[0]);

            if (escolha == -1) {
                System.out.println("Saindo");
                return;
            }

            switch (escolha) {
                case 0:
                    Requests.listgemconvenios();
                    break;
                case 1:
                    Requests.consultaboleto();
                    break;
            }
        }
    }





}
