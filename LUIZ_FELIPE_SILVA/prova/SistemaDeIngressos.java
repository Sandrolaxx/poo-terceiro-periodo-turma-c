// Ana castela, uma coordenadora de eventos, precisa de um novo sistema para gerenciar os eventos e os participantes.
// Desenvolva uma pequena aplicação em java que atenda
// cadastro de cliente , cadastro de evento, listar eventos, comprar ingresso do evento, utilizar ingresso em evento

import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int escolha;
        do {
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                CadastroDoCliente(scanner);
                break;
                case 2:
                    CadastroDoEvento(scanner);
                    break;
                case 3: ListarEventos(scanner);
                
                    
                    break;
            
                default:
                    break;
            }
        
    
}
